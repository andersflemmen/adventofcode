package julekalender

import main.julekalender.getInput

fun main(args: Array<String>) {
    val input = getInput(1).readLines()

    println("Frequency: ${Task1.calculateFrequency(input)}")
    println("First duplicate frequency: ${Task1.findRepeatedFrequency(input)}")
}

class Task1 {
    companion object {
        fun calculateFrequency(input: List<String>): Int {
            return input.map { s -> s.toInt() }.sum()
        }

        fun findRepeatedFrequency(input: List<String>): Int {
            var frequency = 0
            val encountered = mutableSetOf<Int>()

            generateSequence(0) { n -> n + 1 }
                    .map { i -> input[i % input.size].toInt() }
                    .takeWhile { encountered.add(frequency) }
                    .forEach { n -> frequency += n }

            return frequency
        }
    }
}