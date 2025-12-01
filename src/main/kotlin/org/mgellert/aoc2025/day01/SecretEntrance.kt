package org.mgellert.aoc2025.day01

import kotlin.math.abs

class SecretEntrance {

    fun part1(input: List<String>): Int {
        val dial = Dial()
        var dialAtZeroCount = 0
        input.forEach { line ->
            dial.rotate(parseLine(line))
            if (dial.isAtZero()) {
                dialAtZeroCount++
            }
        }
        return dialAtZeroCount
    }

    fun part2(input: List<String>): Int {
        val dial = Dial()
        var dialPassedZeroCount = 0
        input.forEach { line ->
            val r = dial.rotate(parseLine(line))
            dialPassedZeroCount += r
            if (dial.isAtZero()) {
                dialPassedZeroCount++
            }
        }
        return dialPassedZeroCount
    }

    private fun parseLine(line: String): Int {
        val direction = when (line.take(1)) {
            "L" -> -1
            "R" -> 1
            else -> throw IllegalStateException()
        }
        val clicks = line.substring(1).toInt()
        val rotation = direction * clicks
        return rotation
    }

    // TODO: ugly, needs refactoring
    class Dial(var p: Int = 50) {
        fun rotate(rotation: Int): Int {
            val startedAtZero = isAtZero()
            p += rotation % 100
            val passedZero = if (p < 0) {
                p += 100
                1
            } else if (p > 99) {
                p -= 100
                1
            } else {
                0
            }
            return if (isAtZero() || startedAtZero) {
                abs(rotation) / 100
            } else {
                abs(rotation) / 100 + passedZero
            }
        }

        fun isAtZero(): Boolean {
            return p == 0
        }
    }
}