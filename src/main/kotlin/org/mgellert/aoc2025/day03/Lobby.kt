package org.mgellert.aoc2025.day03

import kotlin.math.pow

class Lobby {

    fun parseLine(line: String): List<Long> {
        return line.split("")
            .filter { it.isNotEmpty() }
            .map { it.toLong() }
    }

    fun part1(banks: List<String>): Long = banks.map {
        parseLine(it)
    }.sumOf {
        findMaxJoltage(it, 2)
    }

    fun part2(banks: List<String>): Long = banks.map {
        parseLine(it)
    }.sumOf {
        findMaxJoltage(it, 12)
    }


    fun findMaxJoltage(bank: List<Long>, endPadding: Int, i: Int = 0): Long {
        if (endPadding == 0) return 0
        val subList = bank.subList(i, bank.size - (endPadding - 1))
        val max = subList.max()
        val index = i + subList.indexOf(max)
        return 10.0.pow(endPadding - 1).toLong() * max + findMaxJoltage(bank, endPadding - 1, index + 1)
    }


}