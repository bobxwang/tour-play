import java.time.Clock

import com.google.inject.AbstractModule
import okhttp3.OkHttpClient.Builder
import okhttp3._
import others.{ApplicationTimer, AtomicCounter, Counter}
import play.api.{Configuration, Environment}
import utils.IdWorker

/**
  * this class is a guice module that tell guice how to bind several different types, will created when the play app starts
  * play will automatically use any class called `modules.Module` that is in the root package
  * u can create module in other location by add `play.modules.enabled` settings to the `application.conf` file
  */
class Module(environment: Environment, configuration: Configuration) extends AbstractModule {

  override def configure(): Unit = {

    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone())

    bind(classOf[ApplicationTimer]).asEagerSingleton()

    bind(classOf[Counter]).to(classOf[AtomicCounter])

    bind(classOf[OkHttpClient]).toInstance(new Builder().authenticator(new Authenticator {
      override def authenticate(route: Route, response: Response): Request = {
        val credential = Credentials.basic("bbwithbb", "uguess")
        response.request().newBuilder().header("Authorization", credential).build()
      }
    }).build())

    bind(classOf[IdWorker]).toInstance(new IdWorker(0, 0, 12))
  }
}