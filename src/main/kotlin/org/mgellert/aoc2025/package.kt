package org.mgellert.aoc2025

import java.io.File
import kotlin.math.pow
import kotlin.math.sqrt

fun readInput(fileName: String): List<String> {
    val path = "input/${fileName}"
    val file = File(path)
    if (file.exists()) {
        return file.readLines().filter { it.isNotEmpty() && it.isNotBlank() }
    } else {
        throw IllegalArgumentException("File not found: $path")
    }
}

fun readInputAll(fileName: String): String {
    val path = "input/${fileName}"
    val file = File(path)
    if (file.exists()) {
        return file.readText().trim()
    } else {
        throw IllegalArgumentException("File not found: $path")
    }
}

data class Point(val x: Int, val y: Int) {
    fun plus(other: Point) = Point(this.x + other.x, this.y + other.y)
}

data class Point3D(val x: Long, val y: Long, val z: Long) {
    fun distance(other: Point3D): Double {
        val x2 = (this.x - other.x).toDouble().pow(2)
        val y2 = (this.y - other.y).toDouble().pow(2)
        val z2 = (this.z - other.z).toDouble().pow(2)
        return sqrt(x2 + y2 + z2)
    }
}