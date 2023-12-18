//> using lib "org.scalatest::scalatest::3.2.17"
package adventOfCode.Tests

import puzzles.day1.DayOne

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.{OptionValues, TryValues}

class DayOneTests extends AnyWordSpec with Matchers {
  "values from input" must {
    "in PART ONE calculate the correct output" in {
      val input: Seq[String] = Seq(
        "1abc2",
        "pqr3stu8vwx",
        "a1b2c3d4e5f",
        "treb7uchet"
      )

      val expectedSum = 142
      val actualSum : Int = DayOne.partOne(input)
      actualSum mustBe expectedSum
    }

    "in PART TWO" must {
      "correctly calculate the example input" in {
        val input: Seq[String] = Seq(
          "two1nine",
          "eightwothree",
          "abcone2threexyz",
          "xtwone3four",
          "4nineeightseven2",
          "zoneight234",
          "7pqrstsixteen"
        )

        val expectedSum = 281
        val actualSum : Int = DayOne.partTwo(input)
        actualSum mustBe expectedSum
      }

      "take into account overlap" in {
        val input: Seq[String] = Seq(
          "twone",     // 21
          "eighthree", // 83
          "sevenine",  // 79
          "nineight",  // 98
          "fiveight",  // 58
          "threeight", // 38
          "oneight"    // 18
        )

        val expectedSum = 21+83+79+98+58+38+18
        DayOne.partTwo(input) mustBe (expectedSum)
      }
    }
  }
}
