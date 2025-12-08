package org.mgellert.aoc2025.day08

import org.mgellert.aoc2025.Point3D

class Playground {

    fun parse(line: String): Point3D {
        val (x, y, z) = line.split(",").map { it.toLong() }
        return Point3D(x, y, z)
    }

    fun part1(lines: List<String>, connections: Int = 1000): Long {
        val points = lines.map { parse(it) }
        val sortedByDistance: List<Pair<Point3D, Point3D>> = generateAllDistances(points)
            .map { (points, dist) -> Pair(points, dist) }
            .sortedBy { (_, dist) -> dist }
            .map { (points, _) -> points }
            .take(connections)

        val networks: MutableSet<MutableSet<Point3D>> = points.map { mutableSetOf(it) }.toMutableSet()

        sortedByDistance.forEach { (p1, p2) ->
            val p1network = networks.find { n -> n.contains(p1) }!!
            val p2network = networks.find { n -> n.contains(p2) }!!

            if (p1network != p2network) {
                p1network.addAll(p2network)
                p2network.clear()
            }
        }

        return networks.map { it.size.toLong() }.sorted().reversed().take(3)
            .fold(1L) { product, size -> product * size }
    }

    fun part2(lines: List<String>): Long {
        val points = lines.map { parse(it) }
        val sortedByDistance: List<Pair<Point3D, Point3D>> = generateAllDistances(points)
            .map { (points, dist) -> Pair(points, dist) }
            .sortedBy { (_, dist) -> dist }
            .map { (points, _) -> points }

        val networks: MutableSet<MutableSet<Point3D>> = points.map { mutableSetOf(it) }.toMutableSet()

        sortedByDistance.forEach { (p1, p2) ->
            val p1network = networks.find { n -> n.contains(p1) }!!
            val p2network = networks.find { n -> n.contains(p2) }!!

            if (p1network != p2network) {
                p1network.addAll(p2network)
                p2network.clear()
            }

            val countNonEmptyNetworks = networks.count { it.isNotEmpty() }
            if (countNonEmptyNetworks == 1) {
                return p1.x * p2.x
            }
        }

        return -1
    }

    private fun generateAllDistances(points: Collection<Point3D>): MutableMap<Pair<Point3D, Point3D>, Double> {
        val distances = mutableMapOf<Pair<Point3D, Point3D>, Double>()
        points.forEach { p1 ->
            points.forEach { p2 ->
                if (p1 != p2 && !distances.contains(Pair(p1, p2)) && !distances.contains(Pair(p2, p1))) {
                    val dist = p1.distance(p2)
                    distances[Pair(p1, p2)] = dist
                }
            }
        }
        return distances
    }
}