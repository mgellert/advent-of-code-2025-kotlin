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
        return machines.sumOf { configure(it).toLong() }
    }

    fun configure(machine: Machine): Int {
        var steps = 1
        while (steps < 10) {
            val result = configure(machine, steps)
            if (result < Int.MAX_VALUE) return result
            steps++
        }
        return Int.MAX_VALUE
    }

    fun configure(
        machine: Machine,
        steps: Int,
        step: Int = 0,
        state: List<Boolean> = List(machine.lights.size) { false },
    ): Int {
        if (state == machine.lights) {
            return step
        }
        if (step == steps) {
            return Int.MAX_VALUE
        }

        return machine.buttons.minOf { button ->
            val newState = state.mapIndexed { i, s -> if (i in button) !s else s }
            configure(machine, steps, step + 1, newState)
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