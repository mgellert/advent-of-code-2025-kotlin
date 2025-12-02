package org.mgellert.aoc2025.day02

import org.junit.jupiter.api.Test
import org.mgellert.aoc2025.readInput
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GiftShopTest {

    @Test
    fun testIsInvalid() {
        listOf(
            11L, 22L, 99L, 1010L, 1188511885L, 222222L, 446446L, 38593859L
        ).forEach {
            val isInvalid = GiftShop().isInvalid(it)
            assertTrue(isInvalid)
        }
    }

    @Test
    fun testSumInvalids() {
        listOf(
            Pair(IdRange(11, 22), 33L)
        ).forEach { (idRange, expectedSum) ->
            val sum = GiftShop().sumInvalidIds(idRange)
            assertEquals(expectedSum, sum)
        }
    }

    @Test
    fun testPart1() {
        val input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                "824824821-824824827,2121212118-2121212124"

        val sum = GiftShop().part1(input)
        assertEquals(1227775554, sum)
    }

    @Test
    fun solvePart1() {
        val input = readInput("day02.txt").first()
        val sum = GiftShop().part1(input)
        assertEquals(12850231731, sum)
    }

    @Test
    fun testIsInvalidComplex() {
        listOf(
            11L, 22L, 99L, 111L, 999L, 1010L, 1188511885L, 222222L, 446446L, 38593859L, 565656L, 824824824L, 2121212121L
        ).forEach {
            val isInvalid = GiftShop().isInvalidComplex(it)
            assertTrue(isInvalid)
        }
    }

    @Test
    fun testSumInvalids2() {
        listOf(
            Pair(IdRange(11, 22), 33L)
        ).forEach { (idRange, expectedSum) ->
            val sum = GiftShop().sumInvalidIds2(idRange)
            assertEquals(expectedSum, sum)
        }
    }

    @Test
    fun testPart2() {
        val input = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
                "824824821-824824827,2121212118-2121212124"

        val sum = GiftShop().part2(input)
        assertEquals(4174379265, sum)
    }

    @Test
    fun solvePart2() {
        val input = readInput("day02.txt").first()
        val sum = GiftShop().part2(input)
        assertEquals(24774350322, sum)
    }
}