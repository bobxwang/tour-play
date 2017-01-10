package others

import com.google.inject.{Inject, Provider, Singleton}
import play.api.http.DefaultHttpErrorHandler
import play.api.mvc.RequestHeader
import play.api.mvc.Results._
import play.api.routing.Router
import play.api.{Configuration, Environment, OptionalSourceMapper, UsefulException}

import scala.concurrent.Future

/**
  * Created by bob on 16/10/11.
  */
@Singleton
class ErrorHandler @Inject()(env: Environment, config: Configuration, sourceMapper: OptionalSourceMapper, router: Provider[Router])
  extends DefaultHttpErrorHandler(env, config, sourceMapper, router) {

  override def onClientError(request: RequestHeader, statusCode: Int, message: String) = Future.successful(
    Status(statusCode)("A client error occurred: " + message)
  )

  override def onServerError(request: RequestHeader, exception: Throwable) = Future.successful(
    InternalServerError("A server error occurred: " + exception.getMessage)
  )

  override def onProdServerError(request: RequestHeader, exception: UsefulException) = {
    Future.successful(
      InternalServerError("A server error occurred: " + exception.getMessage)
    )
  }

  override def onForbidden(request: RequestHeader, message: String) = {
    Future.successful(
      Forbidden("You're not allowed to access this resource.")
    )
  }
}