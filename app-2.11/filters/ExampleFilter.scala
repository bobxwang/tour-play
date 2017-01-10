package filters

import com.google.inject.{Inject, Singleton}

import play.api.mvc._

import akka.stream.Materializer

import scala.concurrent.{ExecutionContext, Future}

/**
 * Created by bob on 16/8/2.
 */
@Singleton
class ExampleFilter @Inject()(implicit override val mat: Materializer, exec: ExecutionContext) extends Filter {

  override def apply(nextFilter: RequestHeader => Future[Result])
                    (requestHeader: RequestHeader): Future[Result] = {

    nextFilter(requestHeader).map(result => result.withHeaders("X-ExampleFilter" -> "bbwithbb"))
  }
}