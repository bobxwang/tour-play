package dbgerneration

import java.io.File

import slick.codegen.SourceCodeGenerator
import slick.driver.MySQLDriver
import slick.jdbc.JdbcBackend.Database

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

/**
  * Created by bob on 16/10/13.
  */
object Generation {

  val db = Database.forURL(
    "jdbc:mysql://192.168.2.200:3306/51banka?useUnicode=true&characterEncoding=UTF-8"
    , "root"
    , "zufangbao69fc")

  val filteredTables = MySQLDriver.defaultTables.map(p => {
    p.filter(t => {
      t.name.name.startsWith("T_")
    })
  })

  val modelAction = MySQLDriver.createModel(Option(filteredTables), true)

  def main(args: Array[String]): Unit = {

    val f = new File("").getAbsolutePath
    println(f)

    println("Generating model...")
    val model = Await.result(db.run(modelAction), Duration.Inf)
    model.tables.foreach { table => println(table.name) }
    val codegen = new SourceCodeGenerator(model) {
      override def Table = new Table(_) {
        table =>
        override def Column = new Column(_) {
          override def defaultCode = v => {
            def raw(v: Any) = rawType match {
              case "String" => "\"" + v + "\""
              case "Long" => v + "L"
              case "Float" => v + "F"
              case "Char" => "'" + v + "'"
              case "scala.math.BigDecimal" => v.toString.trim + "d"
              case "Byte" | "Short" | "Int" | "Double" | "Boolean" => v.toString
            }
            v match {
              case Some(x) => s"Some(${raw(x)})"
              case None => "None"
              case x => raw(x)
            }
          }
        }
      }
    }
    println("Generating files...")
    val slickDriver = "slick.driver.MySQLDriver"
    val destPackage = "DBTables"
    codegen.writeToFile(slickDriver, s"${f}/app-2.11/", destPackage, "Tables", "Tables.scala")
    println("Finished codegen.")
  }
}
