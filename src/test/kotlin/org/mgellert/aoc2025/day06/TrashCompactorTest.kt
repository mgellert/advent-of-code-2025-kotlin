package org.mgellert.aoc2025.day06

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mgellert.aoc2025.readInputAll

class TrashCompactorTest {

    @Test
    fun testTranspose() {
        val input = """
            123
             45
              6
            *  
        """.trimIndent()
        val output = TrashCompactor().transpose(input)
        val expected = """
            1  *
            24  
            356 
        """.trimIndent()
        assertEquals(expected, output)

        val output2 = TrashCompactor().transpose(output)
        assertEquals(input, output2)
    }

    @Test
    fun testParse() {
        val input = """
            123 328  51 64 
             45 64  387 23 
              6 98  215 314
            *   +   *   +  
        """.trimIndent()
        val output = TrashCompactor().parse(input)
    }

    @Test
    fun testPart1() {
        val input = """
            123 328  51 64 
             45 64  387 23 
              6 98  215 314
            *   +   *   +  
        """.trimIndent()
        val sum = TrashCompactor().part1(input)
        assertEquals(4277556L, sum)
    }

    @Test
    fun solvePart1() {
        val sum = TrashCompactor().part1(readInputAll("day06.txt"))
        assertEquals(6378679666679L, sum)
    }

    @Test
    fun testPart2() {
        val input = """
            123 328  51 64 
             45 64  387 23 
              6 98  215 314
            *   +   *   +  
        """.trimIndent()
        val sum = TrashCompactor().part2(input)
        assertEquals(3263827L, sum)
    }

    @Test
    fun solvePart2() {
        val sum = TrashCompactor().part2(readInputAll("day06.txt"))
        assertEquals(11494432585168L, sum)
    }
}