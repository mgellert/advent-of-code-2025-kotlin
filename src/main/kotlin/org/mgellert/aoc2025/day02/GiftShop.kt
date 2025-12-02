package org.mgellert.aoc2025.day02

class GiftShop {

    fun isInvalid(n: Long): Boolean {
        val str = n.toString()
        if (str.length % 2 != 0) {
            return false
        }
        val firstHalf = str.take(str.length / 2)
        val secondHalf = str.substring(str.length / 2)
        return firstHalf == secondHalf
    }

    fun isInvalidComplex(n: Long) : Boolean {
        val str = n.toString()
        (1 .. str.length / 2).filter {
            str.length % it == 0
        }.forEach { i ->
            val pattern = str.take(i)
            val isInvalid = str == pattern.repeat(str.length / pattern.length)
            if (isInvalid) {
                return true
            }
        }
        return false
    }

    fun sumInvalidIds(idRange: IdRange): Long {
        var sum = 0L
        (idRange.first..idRange.second).forEach {
            if (isInvalid(it)) sum += it
        }
        return sum
    }

    fun sumInvalidIds2(idRange: IdRange): Long {
        var sum = 0L
        (idRange.first..idRange.second).forEach {
            if (isInvalidComplex(it)) sum += it
        }
        return sum
    }

    fun part1(input: String): Long {
        return parse(input).sumOf { sumInvalidIds(it) }
    }

    fun part2(input: String): Long {
        return parse(input).sumOf { sumInvalidIds2(it) }
    }

    private fun parse(input: String): List<IdRange> {
        return input.split(",").map {
            val (low, high) = it.split("-")
            IdRange(low.toLong(), high.toLong())
        }
    }
}

typealias IdRange = Pair<Long, Long>