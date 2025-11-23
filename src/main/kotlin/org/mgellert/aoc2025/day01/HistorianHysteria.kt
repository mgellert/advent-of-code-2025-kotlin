package org.mgellert.aoc2025.day01

import kotlin.math.abs

class HistorianHysteria {

    private fun parseInput(input: List<String>): Pair<List<Long>, List<Long>> {
        val leftList = mutableListOf<Long>()
        val rightList = mutableListOf<Long>()

        input.forEach { line ->
            val (left, right) = line.split("   ")
            leftList.add(left.trim().toLong())
            rightList.add(right.trim().toLong())
        }

        return Pair(leftList, rightList)
    }

    fun part1(input: List<String>): Long {
        val parsedInput = parseInput(input)

        val leftList = parsedInput.first.sorted()
        val rightList = parsedInput.second.sorted()

        return leftList.zip(rightList).sumOf { (left, right) ->
            abs(left - right)
        }
    }
}