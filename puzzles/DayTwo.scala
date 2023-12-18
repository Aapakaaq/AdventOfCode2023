package puzzles.day2

import puzzles.Puzzle
import utils.InputReader
import scala.util.matching.Regex

object DayTwo extends Puzzle[Int]{
  //@main def main(path : String) : Unit =  run(path)

  private case class Game(id : Int, numbGreen : Int = 0, numbBlue : Int = 0, numbRed : Int = 0)


  override def partOne(input: Seq[String]): Int = {
    input.map(getGame).map( game =>  {
                             game match
                             case Some(game) if isValidGame(game) => game.id
                             case _ => 0
                           }).sum
  }

  override def partTwo(input: Seq[String]): Int = {
    input.map(getGame).map(game => {
                             game match
                             case Some(game) => getPowerSet(game)
                             case _ => 0
                           }).sum
  }


  private val getGame : String => Option[Game] = line => {
    line match
    case s"Game $id: $cubes" => Some(cubes.split(';').foldLeft(Game(id.toInt)) {
                                       // Split Game and samples
                                       case (game, s"$sample") => sample.split(',').map(_.strip()).foldLeft(game) {
                                         // Split the samples to individual cubes
                                         case (game, s"$number green") if number.toInt > game.numbGreen => game.copy(numbGreen = number.toInt)
                                         case (game, s"$number blue")  if number.toInt > game.numbBlue  => game.copy(numbBlue  = number.toInt)
                                         case (game, s"$number red")   if number.toInt > game.numbRed   => game.copy(numbRed   = number.toInt)
                                         case (game, _) => game
                                       }
                                     })
    case _ => None
  }

  private val isValidGame : Game => Boolean = game => game.numbGreen <= 13 && game.numbBlue <= 14 && game.numbRed <= 12

  private val getPowerSet : Game => Int = game => game.numbGreen * game.numbBlue * game.numbRed
}
