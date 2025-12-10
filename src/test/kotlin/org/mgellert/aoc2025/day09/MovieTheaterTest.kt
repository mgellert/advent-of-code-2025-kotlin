package org.mgellert.aoc2025.day09

import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.mgellert.aoc2025.readInput
import kotlin.test.assertEquals

class MovieTheaterTest {

    @Test
    fun testPart1() {
        val input = """
            7,1
            11,1
            11,7
            9,7
            9,5
            2,5
            2,3
            7,3
        """.trimIndent().split("\n")
        val maxArea = MovieTheater().part1(input)
        assertEquals(50, maxArea)
    }

    @Test
    fun solvePart1() {
        val maxArea = MovieTheater().part1(readInput("day09.txt"))
        assertEquals(4781377701L, maxArea)
    }

    @Test
    fun testPart2() {
        val input = """
            7,1
            11,1
            11,7
            9,7
            9,5
            2,5
            2,3
            7,3
        """.trimIndent().split("\n")
        val maxArea = MovieTheater().part2(input)
        assertEquals(24, maxArea)
    }

    @Test @Disabled
    fun solvePart2() {
        val maxArea = MovieTheater().part2(readInput("day09.txt"))
        assertEquals(1470616992L, maxArea)
    }
}