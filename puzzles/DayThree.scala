package puzzles.day3

import puzzles.Puzzle
import utils.InputReader
import scala.util.matching.Regex
import scala.util.{Try}

object DayThree extends Puzzle[Int]{
  @main def main(path : String) : Unit =  run(path)


  override def partOne(input: Seq[String]): Int = {
    val symbols: Seq[Symbol] = getSymbols(input)
    getParts(input).collect{case part if symbols.exists(_.isNeighborOfPart(part)) => part.value}.sum

  }

  override def partTwo(input: Seq[String]): Int = {
    0
  }

  private val supportedSymbols: Seq[Char] = Seq('=', '&', '#', '+', '$', '/', '*', '%', '-', '@')
  private val symbolsRegex: Regex = supportedSymbols.mkString("""(\""", """|\""", ")").r

  private val numberRegex: Regex = "[0-9]+".r
  private val gearRegex: Regex = "\\*".r

  private case class Coordinate(x: Int, y: Int) {
    def isWithin(start: Coordinate, end: Coordinate) = {
      if x < start.x || x > end.x then false
      else if y < start.y || y > end.y then false
      else true
    }
  }

  private case class PartNumber(value: Int, start: Coordinate, end: Coordinate)

  private case class Symbol(symbol: String, pos: Coordinate) {
    def isNeighborOfPart(number : PartNumber) = {
      pos.isWithin(Coordinate(number.start.x - 1, number.start.y -1),
                   Coordinate(number.end.x + 1, number.end.y + 1))
    }
  }

  private val parseToInt : String => Try[Int] = str => Try(str.trim().toInt)

  private val getSymbols : Seq[String] => Seq[Symbol] = str => {
    str.zipWithIndex.flatMap((line, i) => {
                               symbolsRegex.findAllMatchIn(line)
                                 .map{ sym => Symbol(sym.matched, Coordinate(sym.start, i))
                               }
                             })
  }

  private val getParts : Seq[String] => Seq[PartNumber] = str => {
    str.zipWithIndex.flatMap((line, i) => {
                               numberRegex.findAllMatchIn(line)
                                 .map{ numb => {
                                        PartNumber(numb.matched.toInt,
                                                   Coordinate(numb.start, i),
                                                   Coordinate(numb.end - 1, i))
                                      }
                                 }
                             })
  }

  private val getGears : Seq[String] => Seq[Symbol] = str => {
    str.zipWithIndex.flatMap((line, i) => {
                               gearRegex.findAllMatchIn(line)
                                 .map{ sym => Symbol(sym.matched, Coordinate(sym.start, i))
                               }
                             })
  }
}
