package puzzles.day1

import puzzles.Puzzle
import utils.InputReader
import scala.util.matching.Regex

object DayOne extends Puzzle[Int]{
    //@main def main(path : String) : Unit =  run(path)

    def partOne(input: Seq[String]): Int = {
        def lineToCoordinates(line: String): Int = {
            val firstDigit : Char = line.find(_.isDigit).get
            val lastDigit : Char = line.findLast(_.isDigit).get
            val result = s"$firstDigit$lastDigit".toInt
            result
        }

        input.map(lineToCoordinates).sum
    }

    def partTwo(input : Seq[String]) : Int = {
        input.map(findDigitsFromString).sum
    }

    private val digitMap : Map[String, Int] = Map(
        "one"   -> 1,
        "two"   -> 2,
        "three" -> 3,
        "four"  -> 4,
        "five"  -> 5,
        "six"   -> 6,
        "seven" -> 7,
        "eight" -> 8,
        "nine"  -> 9
    )

    private val numberPattern: Regex =
        (digitMap.keys ++ digitMap.values.map(_.toString)).mkString("(?=(","|", "))").r

    private val mapStringDigitToInt: String => Int = input => digitMap.getOrElse(input, input.toInt)

    private val findDigitsFromString : String => Int = input => {
        val matches = numberPattern.findAllIn(input).matchData.toSeq.map(_.group(1))
        val firstDigit = mapStringDigitToInt(matches.head)
        val lastDigit = mapStringDigitToInt(matches.last)
        s"$firstDigit$lastDigit".toInt
    }

}
