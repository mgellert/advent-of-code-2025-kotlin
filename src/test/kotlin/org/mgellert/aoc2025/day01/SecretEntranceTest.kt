package org.mgellert.aoc2025.day01

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mgellert.aoc2025.readInput

class SecretEntranceTest {

    @Test
    fun testPart1() {
        val input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent().split("\n")

        val password = SecretEntrance().part1(input)
        assertEquals(3, password)
    }

    @Test
    fun solvePart1() {
        val input = readInput("day01.txt")
        val password = SecretEntrance().part1(input)
        assertEquals(992, password)
    }

    @Test
    fun testPart2() {
        val input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent().split("\n")

        val password = SecretEntrance().part2(input)
        assertEquals(6, password)
    }

    @Test
    fun solvePart2() {
        val input = readInput("day01.txt")
        val password = SecretEntrance().part2(input)
        assertEquals(6133, password) // too low
    }
}