package main.julekalender

import java.lang.RuntimeException

fun main(args: Array<String>) {
    val input = getInput(3).readLines()
    println("Count: ${Task03.countConflictingSquares(input)}")
    println("No overlap: ${Task03.findClaimWithoutOverlap(input)}")
}

class Task03 {
    companion object {
        fun countConflictingSquares(input: List<String>): Int {
            val matrix = calculateOverlapMatrix(input)

            var count = 0
            for (i in 1 until matrix.size) {
                for (j in 1 until matrix.size) {
                    if (matrix[j][i] > 1) {
                        count++
                    }
                }
            }
            return count
        }

        fun findClaimWithoutOverlap(input: List<String>): Int {
            val matrix = calculateOverlapMatrix(input)
            val cuts = input.map { parseCut(it) }

            for (cut in cuts) {
                var overlap = false
                for (i in 1..cut.width) {
                    for (j in 1..cut.height) {
                        if (matrix[cut.x + i][cut.y + j] > 1) {
                            overlap = true
                        }
                    }
                }
                if (!overlap) {
                    return cut.id
                }
            }
            throw RuntimeException("Found no claim without overlap")
        }

        private fun calculateOverlapMatrix(input: List<String>): Array<IntArray> {
            val fabric = Array(1001) { IntArray(1001) }
            val cuts = input.map { parseCut(it) }

            cuts.forEach {
                for (i in 1..it.width) {
                    for (j in 1..it.height) {
                        fabric[it.x + i][it.y + j]++
                    }
                }
            }

            return fabric
        }

        private fun parseCut(input: String): Cut {
            return Cut(
                    input.substringBefore('@').substring(1).trim().toInt(),
                    input.substringAfter('@').trim().substringBefore(',').toInt(),
                    input.substringAfter(',').trim().substringBefore(':').toInt(),
                    input.substringAfter(':').substringBefore('x').trim().toInt(),
                    input.substringAfter('x').toInt()
            )
        }

        data class Cut(val id: Int, val x: Int, val y: Int, val width: Int, val height: Int)
    }
}
