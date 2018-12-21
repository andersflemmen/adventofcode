package julekalender

import julekalender.Task08.Companion.sumMetadata
import julekalender.Task08.Companion.calculateRootValue
import main.julekalender.getInput

fun main(args: Array<String>) {
    val input = getInput(8).readLines()[0]
    println("Sum of all metadata entries: ${sumMetadata(input)}")
    println("Value of the root node: ${calculateRootValue(input)}")
}

class Task08 {
    companion object {
        fun sumMetadata(input: String): Int {
            return sumMetadata(StringBuffer(input))
        }

        private fun sumMetadata(input: StringBuffer): Int {
            val children = getNext(input)
            val metadata = getNext(input)
            return (1..children)
                    .sumBy { sumMetadata(input) }
                    .plus((1..metadata)
                            .sumBy { getNext(input) })
        }

        fun calculateRootValue(input: String): Int {
            return calculateRootValue(StringBuffer(input))
        }

        private fun calculateRootValue(input: StringBuffer): Int {
            val children = getNext(input)
            val metadata = getNext(input)

            val sums = (1..children).map { calculateRootValue(input) }

            return (1..metadata).sumBy {
                val value = getNext(input)
                if (children == 0) {
                    value
                } else {
                    if (value in 1..children) {
                        sums[value - 1]
                    } else {
                        0
                    }
                }
            }
        }

        private fun getNext(input: StringBuffer): Int {
            val next = input.takeWhile { it != ' ' }.toString()
            input.delete(0, Math.min(next.length + 1, input.length))
            return next.toInt()
        }

    }
}