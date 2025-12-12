package org.mgellert.aoc2025.day10

class Factory {

    fun parse(line: String): Machine {
        val matchResult = regex.find(line)
        val (pattern, groups, numbers) = matchResult!!.destructured

        val lights = pattern.map { it != '.' }
        val buttons = groups.trim().split(Regex("""\s+"""))
            .map { group -> group.removeSurrounding("(", ")").split(",").map { it.toInt() }.toSet() }
        val joltages = numbers.split(",").map { it.toInt() }

        return Machine(lights, buttons, joltages)
    }

    fun part1(lines: List<String>): Long {
        val machines = lines.map { parse(it) }
        return machines.sumOf { configure(it) }
    }

    fun configure(
        machine: Machine,
        steps: Long = 0,
        state: List<Boolean> = List(machine.lights.size) { false },
        cache: MutableMap<List<Boolean>, Long> = mutableMapOf()
    ): Long {
        if (steps > 8) {
            return Long.MAX_VALUE
        }
        if (state == machine.lights) {
            return steps
        }
        if (state in cache && cache[state]!! < steps) {
            return Long.MAX_VALUE
        } else {
            cache[state] = steps
        }

        return machine.buttons.minOf { button ->
            val newState = state.mapIndexed { i, s -> if (i in button) !s else s }
            configure(machine, steps + 1, newState, cache)
        }
    }

    data class Machine(
        val lights: List<Boolean>,
        val buttons: List<Set<Int>>,
        val joltages: List<Int>,
    )

    companion object {
        val regex = Regex("""\[([.#]+)\]\s+(.+?)\s+\{([\d,]+)\}""")
    }
}