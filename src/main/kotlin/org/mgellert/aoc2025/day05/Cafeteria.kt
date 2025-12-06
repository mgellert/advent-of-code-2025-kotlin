package org.mgellert.aoc2025.day05

import kotlin.math.max

class Cafeteria {

    fun parse(input: String): Pair<List<Range>, List<Long>> {
        val (rawRanges, rawIds) = input.split("\n\n")
        val ranges = rawRanges.trim().split("\n").map { line ->
            val (start, end) = line.split("-").map { it.toLong() }
            Range(start, end)
        }
        val ids = rawIds.trim().split("\n").map { it.toLong() }
        return Pair(ranges, ids)
    }

    fun part1(input: String): Int {
        val (ranges, ids) = parse(input)
        return ids.count { id -> ranges.any { it.contains(id) } }
    }

    fun part2(input: String): Long {
        val (unsorted, _) = parse(input)
        val ranges = unsorted.sorted()
        var freshCount = 0L
        var maxId = 0L

        ranges.forEach { range ->
            if (maxId <= range.end) {
                val start = max(maxId, range.start)
                freshCount += range.end - start + 1
                maxId = range.end + 1
            }
        }

        return freshCount
    }

    data class Range(val start: Long, val end: Long): Comparable<Range> {
        fun contains(n: Long) = n in start..end
        override fun compareTo(other: Range): Int = this.start.compareTo(other.start)
    }
}