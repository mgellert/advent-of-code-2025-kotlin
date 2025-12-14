package org.mgellert.aoc2025.day10

class Factory {

    fun parse(line: String): Machine {
        val matchResult = regex.find(line)
        val (pattern, groups, numbers) = matchResult!!.destructured

        val lights = pattern.map { if (it == '#') 1 else 0 }
        val buttons = groups.trim().split(Regex("""\s+"""))
            .map { group -> group.removeSurrounding("(", ")").split(",").map { it.toInt() }.toSet() }
        val joltages = numbers.split(",").map { it.toInt() }

        return Machine(lights, buttons, joltages)
    }

    fun part1(lines: List<String>): Int {
        val machines = lines.map { parse(it) }
        return machines.sumOf { fewestButtonsToConfigure(it) }
    }

    fun fewestButtonsToConfigure(machine: Machine): Int {
        val validSets = mutableSetOf<Set<Button>>()
        fewestButtonsToConfigure(machine, validSets)
        return validSets.minOfOrNull { it.size } ?: -1
    }

    fun fewestButtonsToConfigure(
        machine: Machine,
        validSets: MutableSet<Set<Button>>,
        selected: Set<Button> = mutableSetOf(),
        invalidSets: MutableSet<Set<Button>> = mutableSetOf(),
    ) {
        val state = selected.fold(MutableList(machine.lights.size) { 0 }) { st, btn ->
            btn.forEach { idx -> st[idx] += 1 }
            st
        }.map { it % 2 }

        if (state == machine.lights) {
            validSets.add(selected)
            return
        }
        invalidSets.add(selected)
        machine.buttons
            .filter { !selected.contains(it) }
            .forEach { btn ->
                if (!invalidSets.contains(selected + setOf(btn))) {
                    fewestButtonsToConfigure(machine, validSets, selected + setOf(btn), invalidSets)
                }
            }
    }


    data class Machine(
        val lights: List<Int>,
        val buttons: List<Button>,
        val joltages: List<Int>,
    )

    companion object {
        val regex = Regex("""\[([.#]+)\]\s+(.+?)\s+\{([\d,]+)\}""")
    }
}

typealias Button = Set<Int>
