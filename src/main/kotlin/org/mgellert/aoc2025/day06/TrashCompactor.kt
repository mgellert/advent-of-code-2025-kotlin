package org.mgellert.aoc2025.day06

class TrashCompactor {

    fun part1(input: String): Long {
        val problems = parse(input).map { transpose(it) }
        return problems.sumOf { problem ->
            val split = problem.split("\n")
            val nums = split.subList(0, split.size - 1).map { it.trim().toLong() }
            val operator = split.last().trim()
            if (operator == "+") {
                nums.sum()
            } else {
                nums.fold(1L) { product, n -> product * n }
            }
        }
    }

    fun part2(input: String): Long {
        val problems = parse(input).map { transpose(it) }
        return problems.sumOf { p ->
            val problem = transpose(p)
            val split = problem.split("\n")
            val operator = split.first().last().toString()
            val nums = split.map { it.replace(Regex("[+*]"), "").trim().toLong() }
            if (operator == "+") {
                nums.sum()
            } else {
                nums.fold(1L) { product, n -> product * n }
            }
        }
    }

    fun parse(input: String): List<String> {
        return transpose(input)
            .split("\n")
            .map { it.ifBlank { "" } }
            .joinToString("\n")
            .split("\n\n")
    }

    fun transpose(str: String): String {
        val lines = str.split("\n")
        val result: MutableList<MutableList<Char>> = mutableListOf()
        lines.forEachIndexed { y, line ->
            line.forEachIndexed { x, ch ->
                if (y == 0) result.add(mutableListOf())
                result[x].add(ch)
            }
        }
        return result.joinToString("\n") { it.joinToString("") }
    }
}