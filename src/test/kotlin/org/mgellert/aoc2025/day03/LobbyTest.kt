package org.mgellert.aoc2025.day03

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mgellert.aoc2025.readInput

class LobbyTest {

    @Test
    fun testPart1() {
        val input = """
            987654321111111
            811111111111119
            234234234234278
            818181911112111
        """.trimIndent().split("\n")

        val sum = Lobby().part1(input)
        assertEquals(357, sum)
    }

    @Test
    fun solvePart1() {
        val input = readInput("day03.txt")
        val sum = Lobby().part1(input)
        assertEquals(17142, sum)
    }

    @Test
    fun testPart2() {
        val input = """
            987654321111111
            811111111111119
            234234234234278
            818181911112111
        """.trimIndent().split("\n")

        val sum = Lobby().part2(input)
        assertEquals(3121910778619, sum)
    }

    @Test
    fun solvePart2() {
        val input = readInput("day03.txt")
        val sum = Lobby().part2(input)
        assertEquals(169935154100102, sum)
    }

    @Test
    fun testFindMaxJoltage() {
        listOf(
            Pair("987654321111111", 98L),
            Pair("811111111111119", 89L),
            Pair("234234234234278", 78L),
            Pair("818181911112111", 92L),
        ).forEach {
            val lobby = Lobby()
            val input = lobby.parseLine(it.first)
            val joltage = lobby.findMaxJoltage(input, 2)
            assertEquals(it.second, joltage)
        }
    }

    @Test
    fun testFindMaxJoltage2() {
        listOf(
            Pair("987654321111111", 987654321111L),
            Pair("811111111111119", 811111111119L),
            Pair("234234234234278", 434234234278L),
            Pair("818181911112111", 888911112111L),
        ).forEach {
            val lobby = Lobby()
            val input = lobby.parseLine(it.first)
            val joltage = lobby.findMaxJoltage(input, 12)
            assertEquals(it.second, joltage)
        }
    }

}