package repositories

import com.google.inject.{Inject, Singleton}
import play.api.db.Database
import play.api.db.slick.DatabaseConfigProvider

/**
  * Created by bob on 16/10/13.
  */
@Singleton
class CityRepository @Inject()(val db: Database,
                               val dbConfigProvider: DatabaseConfigProvider) {

  def findById(id: Int) = {

  }

}