package controllers

import com.google.inject.{Inject, Singleton}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller, Result}
import repositories.PersonRepository

import scala.concurrent.ExecutionContext

@Singleton
class PersonController @Inject()(personRepository: PersonRepository)(implicit ec: ExecutionContext) extends Controller {

  def getPersons = Action.async {
    personRepository.list.map(people => Ok(Json.toJson(people)))
  }

  def getPersonById(id: Int) = Action.async {
    personRepository.find(id).map(p => {
      p.fold(NotFound: Result) { fp => Ok(Json.toJson(fp)) }
    })
  }

}