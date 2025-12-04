package org.mgellert.aoc2025.day04

import org.mgellert.aoc2025.Point

class PrintingDepartment {

    fun parseInput(lines: List<String>): Set<Point> {
        val rolls = mutableSetOf<Point>()
        lines.forEachIndexed { y, line ->
            line.forEachIndexed { x, char ->
                if (char == '@') {
                    rolls.add(Point(x, y))
                }
            }
        }
        return rolls
    }

    fun part1(lines: List<String>): Int {
        val rolls = parseInput(lines)
        return rolls.count { roll ->
            val adjacent = deltas.map {
                roll.plus(it)
            }.count {
                rolls.contains(it)
            }
            adjacent < 4
        }
    }

    fun part2(lines: List<String>): Int {
        val rolls = parseInput(lines)
        var prevSize = rolls.size
        var next = removeAccessible(rolls)

        while (prevSize > next.size) {
            prevSize = next.size
            next = removeAccessible(next)
        }

        return rolls.size - next.size
    }

    private fun removeAccessible(rolls: Set<Point>): Set<Point> = rolls.filter { roll ->
        val adjacent = deltas.map { roll.plus(it) }.count { rolls.contains(it) }
        adjacent >= 4
    }.toSet()

    private val deltas = listOf(
        Point(-1, -1),
        Point(0, -1),
        Point(1, -1),
        Point(-1, 0),
        Point(1, 0),
        Point(-1, 1),
        Point(0, 1),
        Point(1, 1),
    )
}