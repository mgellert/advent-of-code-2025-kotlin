package org.mgellert.aoc2025.day01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mgellert.aoc2025.readInput

class HistorianHysteriaTest {

    @Test
    fun testPart1() {
        val testInput = """
            3   4
            4   3
            2   5
            1   3
            3   9
            3   3
        """.trimIndent().split("\n")

        val sum = HistorianHysteria().part1(testInput)
        assertEquals(11, sum)
    }

    @Test
    fun solvePart1() {
        val sum = HistorianHysteria().part1(readInput("day01.txt"))
        assertEquals(1873376, sum)
    }

}