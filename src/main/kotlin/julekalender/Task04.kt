package main.julekalender

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    val input = getInput(4).readLines()

    println("Answer 1: ${Task04.findGuardWithMostMinutesAsleep(input)}")
    println("Answer 2: ${Task04.findGuardMostFrequentlyAsleep(input)}")
}

class Task04 {
    companion object {
        private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")

        fun findGuardWithMostMinutesAsleep(input: List<String>): Int {
            val guardMap = createGuardMap(input)

            val (guard1, guard1Values) = guardMap.entries.maxBy { it.value.sum() }!!
            println("Guard $guard1 slept for ${guard1Values.sum()} minutes")
            val (minute1, value1) = guardMap[guard1]!!.withIndex().maxBy { it.value }!!
            println("Guard $guard1 slept $value1 times on minute $minute1")

            return guard1 * minute1
        }

        fun findGuardMostFrequentlyAsleep(input: List<String>): Int {
            val guardMap = createGuardMap(input)

            val (guard2, guard2Values) = guardMap.entries.maxBy { it.value.max()!! }!!
            val (minute2, value2) = guard2Values.withIndex().maxBy { it.value }!!
            println("Guard $guard2 slept $value2 times on minute $minute2")

            return guard2 * minute2
        }

        private fun createGuardMap(input: List<String>): MutableMap<Int, IntArray> {
           val data = input
                   .map { LogEntry(
                           LocalDateTime.parse(it.substringAfter('[').substringBefore(']'), dateFormat),
                           it.substringAfter(']').trim())
                   }
                   .sortedBy { it.time }

            val map = mutableMapOf<Int, IntArray>()
            var guard: Int = -1
            var sleepingSince = 0
            data.forEach {
                when (it.event) {
                    "wakes up" -> {
                        if (sleepingSince >= 0) {
                            for (i in sleepingSince until it.time.minute) {
                                map[guard]!![i]++
                            }
                            sleepingSince = -1
                        }
                    }
                    "falls asleep" -> {
                        if (sleepingSince < 0) {
                            sleepingSince = it.time.minute
                        }
                    }
                    else -> {
                        guard = it.event.substringAfter('#').substringBefore(' ').toInt()
                        map.putIfAbsent(guard, IntArray(60))
                    }
                }
            }

            return map
        }

        data class LogEntry(val time: LocalDateTime, val event: String)
    }
}


