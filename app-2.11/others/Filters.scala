package others

import com.google.inject.{Inject, Singleton}
import filters.ExampleFilter
import play.api.{Mode, Environment}
import play.api.http.HttpFilters
import play.api.mvc.EssentialFilter

@Singleton
class Filters @Inject()(env: Environment, exampleFilter: ExampleFilter) extends HttpFilters {

  override def filters: Seq[EssentialFilter] = if (env.mode == Mode.Dev) Seq(exampleFilter) else Seq.empty
}