package org.mgellert.aoc2025.day05

import org.junit.jupiter.api.Test
import org.mgellert.aoc2025.readInputAll
import kotlin.test.assertEquals

class CafeteriaTest {

    @Test
    fun testPart1() {
        val input = """
            3-5
            10-14
            16-20
            12-18

            1
            5
            8
            11
            17
            32
        """.trimIndent()
        val fresh = Cafeteria().part1(input)
        assertEquals(3, fresh)
    }

    @Test
    fun solvePart1() {
        val fresh = Cafeteria().part1(readInputAll("day05.txt"))
        assertEquals(773, fresh)
    }

    @Test
    fun testPart2() {
        val input = """
            3-5
            10-14
            16-20
            12-18

            1
            5
            8
            11
            17
            32
        """.trimIndent()
        val fresh = Cafeteria().part2(input)
        assertEquals(14, fresh)
    }

    @Test
    fun solvePart2() {
        val fresh = Cafeteria().part2(readInputAll("day05.txt"))
        assertEquals(332067203034711, fresh)
    }
}