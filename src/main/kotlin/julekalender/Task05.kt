package main.julekalender

import java.util.concurrent.Executors

fun main(args: Array<String>) {
    val beforeInput = System.currentTimeMillis()
    val input = getInput(5).readLines().single()
    val afterInput = System.currentTimeMillis()
    println("Input length: ${input.length}")
    println("Time to read input: ${afterInput - beforeInput} ms\n\n")

    println("Task 1:")
    val before1 = System.currentTimeMillis()
    val reductionResult = Task05.reduce(input)
    val after1 = System.currentTimeMillis()
    println("Remaining input:")
    println(reductionResult)
    println("Length: ${reductionResult.length}")
    println("Time: ${after1 - before1} ms\n\n")

    println("Task 2:")
    val before2 = System.currentTimeMillis()
    val result2 = Task05.findBestPolymerWithoutElement(input)
    val after2 = System.currentTimeMillis()
    println("Removed element: ${result2.first}")
    println("Remaining input:")
    println(result2.second)
    println("Length: ${result2.second.length}")
    println("Time: ${after2 - before2} ms")
}

class Task05 {
    companion object {
        fun reduce(input: String): String {
            var prefix = ""
            var suffix = input

            while (suffix.isNotEmpty()) {
                if (prefix.isNotEmpty() && prefix.last().equals(suffix.first(), true) && prefix.last().isLowerCase() != suffix.first().isLowerCase()) {
                    prefix = prefix.dropLast(1)
                } else {
                    prefix += suffix.take(1)
                }
                suffix = suffix.drop(1)
            }
            return prefix
        }

        fun findBestPolymerWithoutElement(input: String): Pair<Char, String> {
            val pool = Executors.newFixedThreadPool(8)
            val result = ('a'..'z')
                    .map { pool.submit<Pair<Char, String>> { Pair(it, removeElementAndReduce(input, it)) } }
                    .map { it.get() }
                    .minBy { it.second.length }!!
            pool.shutdown()
            return result
        }

        fun removeElementAndReduce(input: String, element: Char): String {
            return Task05.reduce(input.filter { c -> !c.equals(element, true) })
        }
    }
}
