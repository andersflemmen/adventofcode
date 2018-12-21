package julekalender

import julekalender.Task06.Companion.findLargestArea
import julekalender.Task06.Companion.findSizeOfAreaWithLocationsWithTotalDistanceBelowThreshold
import main.julekalender.getInput

fun main(args: Array<String>) {
    println("Largest area: ${findLargestArea(getInput(6).readLines())}")
    println("Size of area with locations with total distance to all given coorinates under 10000: ${findSizeOfAreaWithLocationsWithTotalDistanceBelowThreshold(getInput(6).readLines(), 10000)}")
}

class Task06 {
    companion object {
        fun findLargestArea(input: List<String>): Int {
            val distanceGrid = makeDistanceGrid(input)
            val counts = IntArray(input.size)

            distanceGrid.forEachIndexed { i, line ->
                line.forEachIndexed { j, c ->
                    if (c != '.') {
                        counts[c - 'A']++
                        if (i == 0 || j == 0 || i == distanceGrid.size - 1 || j == distanceGrid[0].size - 1) {
                            counts[c - 'A'] = Int.MIN_VALUE
                        }
                    }
                }
            }

            return counts.max()!!
        }

        fun findSizeOfAreaWithLocationsWithTotalDistanceBelowThreshold(input: List<String>, threshold: Int): Int {
            val coordinates = parseCoorinates(input)
            val xMax = coordinates.maxBy { it.x }!!.x
            val yMax = coordinates.maxBy { it.y }!!.y

            var size = 0
            for (i in 0..yMax) {
                for (j in 0..xMax) {
                    var distance = 0

                    for (k in 0 until coordinates.size) {
                        distance += manhattanDistance(Point(j, i), coordinates[k])
                    }
                    if (distance < threshold) {
                        size++
                    }
                }
            }
            return size
        }

        private fun makeDistanceGrid(input: List<String>): Array<CharArray> {
            val coordinates = parseCoorinates(input)
            val xMax = coordinates.maxBy { it.x }!!.x
            val yMax = coordinates.maxBy { it.y }!!.y

            val grid = Array(yMax + 1) { CharArray(xMax + 1) { '.' } }
            coordinates.forEach { grid[it.y][it.x] = it.id }

            for (i in 0..yMax) {
                for (j in 0..xMax) {
                    var min = listOf(Pair(Int.MAX_VALUE, Point(-1, -1)))
                    coordinates.forEach {
                        val distance = manhattanDistance(Point(j, i), it)
                        if (distance < min.first().first) {
                            min = listOf(Pair(distance, it))
                        } else if (distance == min.first().first) {
                            min = min.plus(Pair(distance, it))
                        }
                    }
                    if (min.size == 1) {
                        grid[i][j] = min.first().second.id
                    }
                }
            }
            return grid
        }

        private fun parseCoorinates(input: List<String>): List<Point> {
            return input.mapIndexed { i, value ->
                Task06.Point(value.substringBefore(',').trim().toInt(), value.substringAfter(',').trim().toInt(), 'A' + i)
            }
        }

        private fun manhattanDistance(point1: Point, point2: Point): Int {
            return Math.abs(point1.x - point2.x) + Math.abs(point1.y - point2.y)
        }
    }

    data class Point(val x: Int, val y: Int, val id: Char = '.')
}