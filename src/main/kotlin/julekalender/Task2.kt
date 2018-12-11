package main.julekalender

import main.julekalender.Task2.Companion.calculateChecksum
import main.julekalender.Task2.Companion.findCommonLettersForPrototypeBoxes
import java.lang.RuntimeException

fun main(args: Array<String>) {
    val input = getInput(2).readLines()

    println("Checksum: ${calculateChecksum(input)}")
    println("Common letters for prototype boxes: ${findCommonLettersForPrototypeBoxes(input)}")
}

class Task2 {
    companion object {
        fun calculateChecksum(input: List<String>): Int {
            var twos = 0
            var threes = 0

            input.forEach { line ->
                val count = IntArray(26)
                line.forEach {
                    count[it.toInt() - 97]++
                }
                if (count.any { it == 2 }) twos++
                if (count.any { it == 3 }) threes++
            }
            return twos * threes
        }

        fun findCommonLettersForPrototypeBoxes(input: List<String>): String {
            for (i in 0 until input.size) {
                for (j in i + 1 until input.size) {
                    val equal = input[i].zip(input[j]).filter { it.first == it.second }.map { it.first }
                    if (equal.size == input[i].length - 1) {
                        return equal.joinToString("")
                    }
                }
            }
            throw RuntimeException("Could not find prototype boxes")
        }
    }
}
