package julekalender

import julekalender.Task10.Companion.findMessage
import main.julekalender.getInput

fun main(args: Array<String>) {
    val input = getInput(10).readLines()
    val (time, sky) = findMessage(input)

    println("Time: $time")
    println(sky)
}

class Task10 {
    companion object {

        fun findMessage(input: List<String>): Pair<Int, String> {
            var lights = parseLights(input)

            var i = 0
            var previousWidth = Int.MAX_VALUE
            while (true) {
                val next = lights.map { it.move() }

                val width = next.maxBy { it.x }!!.x - next.minBy { it.x }!!.x
                if (width > previousWidth) {
                    val minX = lights.minBy { it.x }!!.x
                    val maxX = lights.maxBy { it.x }!!.x
                    val minY = lights.minBy { it.y }!!.y
                    val maxY = lights.maxBy { it.y }!!.y

                    val sky = Array(maxY - minY + 1) { CharArray(maxX - minX + 1) { '.' } }
                    lights.forEach {
                        sky[it.y - minY][it.x - minX] = '#'
                    }

                    val skyString = sky.joinToString("\n") { it.joinToString("") }
                    return Pair(i, skyString)
                } else {
                    i++
                    previousWidth = width
                    lights = next
                }
            }
        }

        private fun parseLights(input: List<String>): List<Light> {
            return input.map {
                val position = it.substringBefore("velocity").substringAfter("position")
                val velocity = it.substringAfter("velocity")
                Light(
                        position.substringAfter("<").substringBefore(",").trim().toInt(),
                        position.substringAfter(",").substringBefore(">").trim().toInt(),
                        velocity.substringAfter("<").substringBefore(",").trim().toInt(),
                        velocity.substringAfter(",").substringBefore(">").trim().toInt()
                    )
            }.sortedWith(compareBy({ it.y }, { it.x }))
        }
    }

    private data class Light(val x: Int, val y: Int, val vX: Int, val vY: Int) {
        fun move(): Light {
            return Light(x + vX, y + vY, vX, vY)
        }
    }
}