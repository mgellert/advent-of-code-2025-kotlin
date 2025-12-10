package org.mgellert.aoc2025.day09

import org.mgellert.aoc2025.Point
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class MovieTheater {

    fun parse(line: String): Point {
        val (x, y) = line.split(",").map { it.toInt() }
        return Point(x, y)
    }

    fun part1(lines: List<String>): Long {
        var maxArea = 0L
        val points = lines.map { parse(it) }
        points.forEach { p1 ->
            points.forEach { p2 ->
                if (p1 != p2) {
                    val area = (abs(p1.x - p2.x).toLong() + 1) * (abs(p1.y - p2.y) + 1)
                    if (area > maxArea) {
                        maxArea = area
                    }
                }
            }
        }
        return maxArea
    }

    fun part2(lines: List<String>): Long {
        val points = lines.map { parse(it) }
        val greens = createGreenTiles(points)

        var maxArea = 0L
        points.forEach { p1 ->
            points.forEach { p2 ->
                if (p1 != p2) {
                    val insideP1 = Point(p1.x + sign(p2.x - p1.x), p1.y + sign(p2.y - p1.y))
                    val insideP2 = Point(p2.x + sign(p1.x - p2.x), p2.y + sign(p1.y - p2.y))
                    val inside = greens.any { p ->
                        val minX = min(insideP1.x, insideP2.x)
                        val maxX = max(insideP1.x, insideP2.x)
                        val minY = min(insideP1.y, insideP2.y)
                        val maxY = max(insideP1.y, insideP2.y)
                        p.x >= minX && p.x <= maxX && p.y >= minY && p.y <= maxY
                    }
                    val area = (abs(p1.x - p2.x).toLong() + 1) * (abs(p1.y - p2.y) + 1)
                    if (area > maxArea && !inside) {
                        maxArea = area
                    }
                }
            }
        }

//        printMap(points.toSet(), greens)
        return maxArea
    }

    private fun createGreenTiles(points: List<Point>): Set<Point> {
        val greens = mutableSetOf<Point>()

        (0..<points.size).forEach { i ->
            val p1 = points[i]
            val p2 = if (i == points.size - 1) points[0] else points[i + 1]

            val dx = sign(p2.x - p1.x)
            val dy = sign(p2.y - p1.y)

            var p = Point(p1.x + dx, p1.y + dy)
            while (p != p2) {
                greens.add(p)
                p = Point(p.x + dx, p.y + dy)
            }
        }

        return greens
    }

    private fun sign(n: Int) = when {
        n > 0 -> 1
        n == 0 -> 0
        else -> -1
    }

    private fun printMap(reds: Set<Point>, greens: Set<Point>) {
        val xMax = reds.maxOf { it.x } + 1
        val yMax = reds.maxOf { it.y } + 1
        (0..yMax).forEach { y ->
            (0..xMax).forEach { x ->
                val p = Point(x, y)
                when {
                    reds.contains(p) -> print("R")
                    greens.contains(p) -> print("G")
                    else -> print(".")
                }
            }
            println()
        }
    }
}