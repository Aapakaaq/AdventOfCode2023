package puzzles

import utils.InputReader
import scala.util.{Failure, Success, Try}
trait Puzzle[T]{

  def partOne(input: Seq[String]): T
  def partTwo(input: Seq[String]): T


  protected def run(path : String) =
    val readResult = InputReader.readLines(path)
    printResult(part = "1", readResult = readResult, processInput = partOne)
    printResult(part = "2", readResult = readResult, processInput = partTwo)

  private def printResult(part:         String,
                          readResult:   Try[Seq[String]],
                          start:        Long = System.currentTimeMillis,
                          processInput: Seq[String] => T): Unit =
    val results =
      for {
        input <- readResult
        output <- Try(processInput(input))
      } yield output


    results match
        case Failure(ex) =>
            println(s"Error while processing input for part $part, ${ex.getMessage}" )
        case Success(result) =>
            println(s"The result is: $result  and took around ${System.currentTimeMillis - start} ms")


}
