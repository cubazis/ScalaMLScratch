package ScalaLearn.Utils

import scala.io.{BufferedSource, Source}
import scala.util.Try

/**
  * Created by dan.dixey on 10/06/2017.
  */
object IOUtils {

  def parseDouble(s: String): Option[Double] = Try { s.toDouble }.toOption

  /** Load the file by name from the resources folder
    *
    * @param fileName   Name of the file
    * @return
    */
  def readData(fileName: String): List[Array[Double]] = {
    val unParsed: BufferedSource = Source.fromFile(fileName)
    unParsed.getLines().map(x => x.split(",").map(_.toDouble)).toList
  }
}
