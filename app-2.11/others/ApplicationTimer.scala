package others

import java.io.File
import java.time.{Clock, Instant}

import akka.actor.{Actor, ActorSystem, Props}
import akka.util.Timeout
import com.google.inject.{Inject, Singleton}
import okhttp3.{OkHttpClient, Request}
import org.joda.time.DateTime
import play.api.Logger
import play.api.inject.ApplicationLifecycle
import play.api.libs.json.{JsValue, Json}
import utils.FileUtils

import scala.concurrent.Future
import scala.concurrent.duration._

case class USMonitor(serviceName: String, map: Map[String, String], keys: List[String])

class RiskWorkerActor(okHttpClient: OkHttpClient) extends Actor {
  val currentPath = new File("").getAbsolutePath
  val requestBuild = new Request.Builder()

  val urlMaps = Map("172.16.40.68" -> "http://172.16.40.68:8090/bbonly/metrics", "172.16.40.69" -> "http://172.16.40.69:8090/bbonly/metrics")
  val keys = List("counter.status.200.calculator.users.anticheat",
    "counter.status.200.calculator.users.category",
    "counter.status.200.calculator.users.credit",
    "counter.status.200.calculator.users.location",
    "counter.status.200.calculator.users.salary",
    "counter.status.500.calculator.users.anticheat",
    "counter.status.500.calculator.users.category",
    "counter.status.500.calculator.users.credit",
    "counter.status.500.calculator.users.location",
    "counter.status.500.calculator.users.salary",
    "gauge.response.calculator.users.anticheat",
    "gauge.response.calculator.users.category",
    "gauge.response.calculator.users.credit",
    "gauge.response.calculator.users.location",
    "gauge.response.calculator.users.salary"
  )
  val riskService = USMonitor("risk-openapi", urlMaps, keys)
  val services: List[USMonitor] = List(riskService)

  override def receive: Receive = {
    case "start" => {
      val now = DateTime.now().toString("yyyy-MM-dd HH:mm:ss")
      services.foreach(s => {
        s.map.foreach(sx => {
          val rs = okHttpClient.newCall(requestBuild.url(sx._2).build).execute
          if (rs.isSuccessful) {
            val jv: JsValue = Json.parse(rs.body.string)
            val sb = new StringBuilder()
            keys.foldLeft(sb)((z, y) => {
              val temp = (jv \ y).toOption.map(_.toString())
              val nvalue = temp.getOrElse(if (y.startsWith("gauge")) "0.0" else "0")
              z.append(s"('${s.serviceName}','${sx._1}','${y}','${nvalue}','${now}'),")
              z
            })
            val ssql = sb.insert(0, s"insert into `T_Access_Count` (`servicename`,`machinename`,`methodname`,`nvalue`,`createtime`) values ").dropRight(1).append(";").toString
            FileUtils.writeToFile(s"${currentPath}/online.txt", ssql + "\n")
          }
        })
      })
    }
    case "stop" => context.stop(self)
    case _ =>
  }
}

@Singleton
class ApplicationTimer @Inject()(okHttpClient: OkHttpClient, clock: Clock, appLifecycle: ApplicationLifecycle) {

  private val start: Instant = clock.instant()
  Logger.info(s"Application started at ${start}")

  val system = ActorSystem("actorSystem")
  implicit val time = Timeout(5.seconds)
  val riskActor = system.actorOf(Props(new RiskWorkerActor(okHttpClient)), "riskWorkerActor")
  //  var taskCancellable: Cancellable = system.scheduler.schedule(1.milliseconds, 5.minutes, riskActor, "start")

  // here we can do sth like notify the service register that this app has started and want to service

  appLifecycle.addStopHook { () => {

    // here wc also can do sth like notify the register service that this app has stoped and please remove it from the service list

    val stop = clock.instant()
    val runTime = stop.getEpochSecond - start.getEpochSecond
    Logger.info(s"Application stoped at ${clock.instant()} after runing ${runTime}s")
    //    taskCancellable.cancel()
    Future.successful((Unit))
  }
  }
}