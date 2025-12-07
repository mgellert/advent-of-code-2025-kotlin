package org.mgellert.aoc2025.day07

import org.mgellert.aoc2025.day07.Type.EMPTY_SPACE
import org.mgellert.aoc2025.day07.Type.SPLITTER


class Laboratories {

    fun parse(lines: List<String>): MutableList<MutableList<Node>> {
        val map = mutableListOf<MutableList<Node>>()
        lines.forEach { line ->
            val row = mutableListOf<Node>()
            line.forEach { ch ->
                when (ch) {
                    'S' -> row.add(Node(EMPTY_SPACE, 1))
                    '^' -> row.add(Node(SPLITTER))
                    else -> row.add(Node(EMPTY_SPACE))
                }
            }
            map.add(row)
        }
        return map
    }

    fun part1(lines: List<String>): Int {
        val map = parse(lines)
        (0..<map.size - 1).forEach { y ->
            map[y].forEachIndexed { x, n ->
                if (n.isSplitter()) {
                    map.addBeam(y, x - 1, n.beamStrength)
                    map.addBeam(y, x + 1, n.beamStrength)
                }
            }
            map[y].forEachIndexed { x, n ->
                if (n.hasBeam()) {
                    map.addBeam(y + 1, x, n.beamStrength)
                }
            }
        }
//        print(map)
        return map.sumOf { row -> row.map { if (it.isSplitter() && it.beamStrength > 0) 1 else 0 }.sum() }
    }

    fun part2(lines: List<String>): Long {
        val map = parse(lines)
        (0..<map.size - 1).forEach { y ->
            map[y].forEachIndexed { x, n ->
                if (n.isSplitter()) {
                    map.addBeam(y, x - 1, n.beamStrength)
                    map.addBeam(y, x + 1, n.beamStrength)
                }
            }
            map[y].forEachIndexed { x, n ->
                if (n.hasBeam()) {
                    map.addBeam(y + 1, x, n.beamStrength)
                }
            }
        }
//        print(map)
        return map.last().sumOf { it.beamStrength }
    }
}

enum class Type {
    SPLITTER, EMPTY_SPACE
}

private fun print(map: List<List<Node>>) {
    map.forEach { line ->
        println(line.joinToString("") { it.toString() })
    }
}

class Node(val type: Type, var beamStrength: Long = 0) {
    fun isSplitter() = type == SPLITTER
    fun hasBeam() = beamStrength > 0 && type == EMPTY_SPACE
    override fun toString(): String {
        return if (type == SPLITTER) "^"
        else if (beamStrength > 0) "|"
        else "."
    }
}

private fun MutableList<MutableList<Node>>.addBeam(y: Int, x: Int, beamStrength: Long) {
    val n = this[y][x]
    n.beamStrength += beamStrength
}
