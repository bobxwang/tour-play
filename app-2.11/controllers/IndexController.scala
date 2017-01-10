package controllers

import java.io.File

import com.google.inject.{Inject, Singleton}
import models.Person
import play.api.Logger
import play.api.libs.json.JsValue
import play.api.mvc.{Action, Controller, Result, _}
import repositories.{BankRepository, CityRepository}
import utils.IdWorker

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

@Singleton
class IndexController @Inject()(idWorker: IdWorker
                                , bankRepository: BankRepository
                                , cityRepository: CityRepository) extends Controller {

  /**
    * session
    * flash => data are kept for only one request
    */

  implicit val customerCharset = Codec.javaSupported("utf-8")

  val ok = Ok("hello world").withCookies(Cookie("theme", "blue"))
  val notFound = NotFound
  val pageNotFound = NotFound(<h1>page not found</h1>).as(HTML)
  val oops = InternalServerError("Oops")
  val anyStatus = Status(488)("Strange response type")
  // the default status is 303 SEE_OTHER
  val redirect = Redirect("/persons")
  val redirectWithStatus = Redirect("/persons/1", MOVED_PERMANENTLY)

  object LoggintAction extends ActionBuilder[Request] {
    def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = {
      Logger.info("Calling action")
      block(request)
    }
  }

  object LoggingAction extends ActionBuilder[Request] {
    def invokeBlock[A](request: Request[A], block: (Request[A]) => Future[Result]) = block(request)

    override protected def composeAction[A](action: Action[A]) = new Logging(action)
  }

  case class Logging[A](action: Action[A]) extends Action[A] {

    override def apply(request: Request[A]) = {
      Logger.info("Calling action from Logging")
      action(request)
    }

    lazy val parser = action.parser
  }

  def logging[A](action: Action[A]) = Action.async(action.parser) {
    request => {
      Logger.info("Calling action from def")
      action(request)
    }
  }

  def xForwardedFor[A](action: Action[A]) = Action.async(action.parser) {
    request => {
      val newrequest = request.headers.get("X-Forwarded-For").map(xff => {
        new WrappedRequest[A](request) {
          override def remoteAddress = xff
        }
      }).getOrElse(request)
      action(newrequest)
    }
  }

  import scala.concurrent.ExecutionContext.Implicits.global

  def addUaHeader[A](action: Action[A]) = Action.async(action.parser) { request =>
    action(request).map(_.withHeaders("X-UA-Compatible" -> "Chrome=1"))
  }

  def onlyHttps[A](action: Action[A]) = Action.async(action.parser) { request =>
    request.headers.get("X-Forwarded-Proto").collect {
      case "https" => action(request)
    } getOrElse {
      Future.successful(Forbidden("Only HTTPS requests allowed"))
    }
  }

  class UserRequest[A](val username: Option[String], request: Request[A]) extends WrappedRequest[A](request)

  object UserAction extends
    ActionBuilder[UserRequest] with ActionTransformer[Request, UserRequest] {

    override def transform[A](request: Request[A]) = Future.successful {
      new UserRequest(request.session.get("username"), request)
    }
  }

  def index = LoggintAction { request => {

    val p = List[Person](Person(1, "name", 1), Person(2, "bname", 2))
    Ok(views.html.vndex(Person(0, "name", 0), p))

    //    Result(
    //      header = ResponseHeader(200, Map.empty),
    //      body = HttpEntity.Strict(ByteString("Hello play, how r u!"), Some("text/plain"))
    //    )
  }
  }

  def indexView = Action.async {

    //    val rs = bankRepository.list()
    //    Await.result(rs, Duration.Inf)
    //    val rss = rs.map(r => r.flatMap(ri => ri.name))
    //    rss.map(s => Ok(s.toString))

    val bid = bankRepository.findById(2)
    if (bid.isCompleted) {
      bid.onComplete(i => {
        if (i.isSuccess) {
          println(i.get.name.toString)
        } else {
          println("error")
        }
      })
    }
    Await.result(bid, Duration.Inf)
    bid.map(x => Ok(x.toString))
  }

  def indexHello = Action {
    Redirect(routes.IndexController.index())
  }

  def save = Action { request =>
    val body: AnyContent = request.body
    val jsonBody: Option[JsValue] = body.asJson

    jsonBody.map { json =>
      Ok("Got: " + (json \ "name").as[String])
    }.getOrElse {
      BadRequest("Expecting application/json request body")
    }
  }

  def savejosn = Action(parse.json) { request =>
    Ok("Got: " + (request.body \ "name").as[String])
  }

  val storeInUserFile = parse.using { request =>
    request.session.get("username").map { user =>
      parse.file(
        to = new File("/tmp/" + user + ".upload"))
    }.getOrElse {
      sys.error("You don't have the right to upload here")
    }
  }

  def savefile = Action(storeInUserFile) {
    request => {
      Ok("Saved the request content to " + request.body)
    }
  }

  def home = TODO
}