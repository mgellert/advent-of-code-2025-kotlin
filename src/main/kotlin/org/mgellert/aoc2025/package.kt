package org.mgellert.aoc2025

import java.io.File

fun readInput(fileName: String) : List<String> {
    val path = "input/${fileName}"
    val file = File(path)
    if (file.exists()) {
        return file.readLines().filter { it.isNotEmpty() && it.isNotBlank() }
    } else {
        throw IllegalArgumentException("File not found: $path")
    }
}