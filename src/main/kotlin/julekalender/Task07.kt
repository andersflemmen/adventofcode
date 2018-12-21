package julekalender

import julekalender.Task07.Companion.calculateTimeToComplete
import julekalender.Task07.Companion.calculateOrder
import main.julekalender.getInput


fun main(args: Array<String>) {
    val input = getInput(7).readLines()
    println("Step order: ${calculateOrder(input)}")
    println("Time to complete all steps: ${calculateTimeToComplete(input, 5, 60)}")
}

class Task07 {
    companion object {
        fun calculateOrder(input: List<String>): String {
            val edges = parseEdges(input)
            val nodes = edges
                    .map { listOf(it.from, it.to) }
                    .flatten()
                    .toSortedSet()

            val order = mutableListOf<Char>()
            val unvisitedNodes = nodes.toMutableList()
            val unresolvedEdges = edges.toMutableList()

            while (unvisitedNodes.isNotEmpty()) {
                val possibleNodes = unvisitedNodes.toMutableList()
                unresolvedEdges.forEach {
                    possibleNodes.remove(it.to)
                }
                val nextNode = possibleNodes.first()
                order.add(nextNode)
                unvisitedNodes.remove(nextNode)
                unresolvedEdges.removeAll { it.from == nextNode }
            }
            return order.joinToString("")
        }

        fun calculateTimeToComplete(input: List<String>, numberOfWorkers: Int, constantWorkTime: Int): Int {
            val edges = parseEdges(input)
            val nodes = edges
                    .map { listOf(it.from, it.to) }
                    .flatten()
                    .toSortedSet()

            val possibleEdges = edges.toMutableList()
            val notStarted = nodes.toMutableSet()
            val inProgress = mutableListOf<Job>()
            val completed = mutableListOf<Char>()
            var currentTime = -1

            while (notStarted.isNotEmpty() || inProgress.isNotEmpty()) {
                currentTime++
                inProgress.filter { it.completionTime == currentTime }
                        .forEach {
                            completed.add(it.name)
                            possibleEdges.removeAll { edge -> it.name == edge.from }
                        }
                inProgress.removeAll { it.completionTime == currentTime }

                val available = notStarted
                        .filter { c -> possibleEdges.none { it.to == c } }
                        .sortedBy { it }
                        .toMutableList()

                while (available.isNotEmpty() && inProgress.size < numberOfWorkers) {
                    val next = available.removeAt(0)
                    inProgress.add(Job(next, next - 'A' + 1 + constantWorkTime + currentTime))
                    notStarted.remove(next)
                }
            }

            return currentTime
        }

        private fun parseEdges(input: List<String>): List<Edge> {
            return input.map { line ->
                        Edge(line.substringAfter("Step").substringBefore("must").trim()[0],
                                line.substringAfter("step").substringBefore("can").trim()[0])
                    }
        }

        private data class Edge(val from: Char, val to: Char)
        private data class Job(val name: Char, val completionTime: Int)
    }
}