package org.mgellert.aoc2025.day08

import org.junit.jupiter.api.Test
import org.mgellert.aoc2025.readInput
import kotlin.test.assertEquals

class PlaygroundTest {

    @Test
    fun testPart1() {
        val input = """
            162,817,812
            57,618,57
            906,360,560
            592,479,940
            352,342,300
            466,668,158
            542,29,236
            431,825,988
            739,650,466
            52,470,668
            216,146,977
            819,987,18
            117,168,530
            805,96,715
            346,949,466
            970,615,88
            941,993,340
            862,61,35
            984,92,344
            425,690,689
        """.trimIndent().split("\n")
        val result = Playground().part1(input, 10)
        assertEquals(40, result)
    }

    @Test
    fun solvePart1() {
        val result = Playground().part1(readInput("day08.txt"))
        assertEquals(102816, result)
    }

    @Test
    fun testPart2() {
        val input = """
            162,817,812
            57,618,57
            906,360,560
            592,479,940
            352,342,300
            466,668,158
            542,29,236
            431,825,988
            739,650,466
            52,470,668
            216,146,977
            819,987,18
            117,168,530
            805,96,715
            346,949,466
            970,615,88
            941,993,340
            862,61,35
            984,92,344
            425,690,689
        """.trimIndent().split("\n")
        val result = Playground().part2(input)
        assertEquals(25272, result)
    }

    @Test
    fun solvePart2() {
        val result = Playground().part2(readInput("day08.txt"))
        assertEquals(100011612, result)
    }
}