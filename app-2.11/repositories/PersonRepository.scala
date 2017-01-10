package repositories

import com.google.inject.{Inject, Singleton}
import models.Person
import others.Counter

import scala.concurrent.{Future, ExecutionContext}

@Singleton
class PersonRepository @Inject()(counter: Counter)(implicit ec: ExecutionContext) {

  private val persons = scala.collection.mutable.ListBuffer[Person]()
  (1 to 5).foreach(x => persons.append(Person(counter.nextLong(), "b" * x, x)))

  def create(name: String, age: Int): Future[Person] = {

    val person = Person(counter.nextLong(), name, age)
    persons.append(person)
    Future {
      person
    }
  }

  def list: Future[Seq[Person]] = Future {
    persons
  }

  def find(id: Long): Future[Option[Person]] = Future {
    persons.find(p => p.id == id)
  }
}