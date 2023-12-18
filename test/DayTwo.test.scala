package adventOfCode.Tests

import puzzles.day2.DayTwo

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.{OptionValues, TryValues}

class DayTwoTests extends AnyWordSpec with Matchers {
  "values from input" must {
    "in PART ONE calculate the correct output" in {
      val input: Seq[String] = Seq(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
      )

      val expectedSum = 8
      val actualSum = DayTwo.partOne(input)
      actualSum mustBe expectedSum
    }

    "in PART TWO calculate the correct output" in {
      val input : Seq[String] = Seq(
        "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
        "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
        "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
        "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
        "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
      )

      val expectedSum = 2286
      val actualSum = DayTwo.partTwo(input)
      actualSum mustBe expectedSum
    }

  }
}
