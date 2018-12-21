package julekalender

import julekalender.Task09.Companion.parseInput
import julekalender.Task09.Companion.play
import main.julekalender.getInput

fun main(args: Array<String>) {
    val input = getInput(9).readLines().first()
    val (players, marbles) = parseInput(input)

    println("Winnings score with $players players and $marbles marbles: ${play(players, marbles)}")
    println("Winnings score with $players players and ${marbles * 100} marbles: ${play(players, marbles * 100)}")
}

class Task09 {
    companion object {

        fun play(players: Int, marbles: Int): Long {
            val scores = LongArray(players)

            var currentPlayer = 0
            var currentNode = ListNode(0)

            for (i in 1..marbles) {
                if (i % 23 == 0) {
                    scores[currentPlayer] += i.toLong()
                    (1..7).forEach { currentNode = currentNode.previous }
                    scores[currentPlayer] += currentNode.value.toLong()
                    currentNode.previous.next = currentNode.next
                    currentNode.next.previous = currentNode.previous
                    currentNode = currentNode.next
                } else {
                    currentNode = currentNode.next
                    currentNode = ListNode(currentNode, i, currentNode.next)
                }
                currentPlayer = (currentPlayer + 1) % players
            }
            return scores.max()!!
        }

        fun parseInput(input: String): Pair<Int, Int> {
            val players = input.substringBefore("players").trim().toInt()
            val marbles = input.substringAfter("worth").substringBefore("points").trim().toInt()
            return Pair(players, marbles)
        }
    }

    private class ListNode(val value: Int) {

        constructor(previous: ListNode, value: Int, next: ListNode) : this(value) {
            this.next = next
            this.previous = previous
            previous.next = this
            next.previous = this
        }

        var next: ListNode = this
        var previous: ListNode = this
    }
}