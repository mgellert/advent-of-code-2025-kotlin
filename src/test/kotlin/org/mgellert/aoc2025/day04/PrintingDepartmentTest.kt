package org.mgellert.aoc2025.day04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mgellert.aoc2025.readInput

class PrintingDepartmentTest {

    @Test
    fun testPart1() {
        val input = """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
        """.trimIndent().split("\n")

        val count = PrintingDepartment().part1(input)
        assertEquals(13, count)
    }

    @Test
    fun solvePart1() {
        val input = readInput("day04.txt")
        val count = PrintingDepartment().part1(input)
        assertEquals(1569, count)
    }

    @Test
    fun testPart2() {
        val input = """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
        """.trimIndent().split("\n")

        val count = PrintingDepartment().part2(input)
        assertEquals(43, count)
    }

    @Test
    fun solvePart2() {
        val input = readInput("day04.txt")
        val count = PrintingDepartment().part2(input)
        assertEquals(9280, count)
    }

}