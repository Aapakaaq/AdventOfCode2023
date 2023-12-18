package adventOfCode.Tests

import puzzles.day3.DayThree

import org.scalatest.matchers.must.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.{OptionValues, TryValues}

class DayThreeTests extends AnyWordSpec with Matchers {
  "values from input" must {
    "in PART ONE calculate the correct output" in {
      val input: Seq[String] = Seq(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...$.*....",
        ".664.598.."
      )

      val expectedSum = 4361
      val actualSum : Int = DayThree.partOne(input)

      actualSum mustBe expectedSum
    }


    "in PART TWO calculate the correct output" in {
      val input: Seq[String] = Seq(
        "467..114..",
        "...*......",
        "..35..633.",
        "......#...",
        "617*......",
        ".....+.58.",
        "..592.....",
        "......755.",
        "...$.*....",
        ".664.598.."
      )

      val expectedSum = 467835
      val actualSum : Int = DayThree.partTwo(input)

      actualSum mustBe expectedSum
    }
  }
}
