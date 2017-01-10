package utils

import java.io.FileWriter

/**
 * Created by bob on 16/8/2.
 */
object FileUtils {

  private def using[A <: {def close() : Unit}, B](param: A)(f: A => B): B =
    try {
      f(param)
    } finally {
      param.close()
    }

  def writeToFile(fileName: String, data: String) =
    using(new FileWriter(fileName, true)) {
      fileWriter => {
        fileWriter.append(data)
      }
    }
}
