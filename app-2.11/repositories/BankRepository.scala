package repositories

import DBTables.Tables._
import com.google.inject.{Inject, Singleton}
import play.api.db.Database
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.driver.JdbcProfile

import scala.concurrent.Future

/**
  * Created by bob on 16/10/11.
  */
@Singleton
class BankRepository @Inject()(val defaultdb: Database,
                               val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile] {

  val Areas = TAreaFull

  import dbConfig.driver.api._

  def findById(id: Int): Future[TAreaFullRow] = {

    db.run(Areas.filter(_.areaid === id).result.head)
  }

  def list(): Future[Seq[TAreaFullRow]] = {

    db.run(Areas.result)

  }

}