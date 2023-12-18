package utils

import scala.io.Source
import scala.util.{Try, Using}

object InputReader:
  lazy val readLines: String => Try[Seq[String]] =
    path => Using(Source.fromFile(path))(source => source.getLines().toSeq)
end InputReader
