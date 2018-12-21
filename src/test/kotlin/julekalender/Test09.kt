package julekalender

import julekalender.Task09.Companion.parseInput
import julekalender.Task09.Companion.play
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test09 {

    @Test
    @DisplayName("The number of players and marbles should be correctly parsed from the input")
    fun sumMetadataDummyData() {
        val (players, marbles) = parseInput("734 players; last marble is worth 20394 points")
        assertThat(players, `is`(734))
        assertThat(marbles, `is`(20394))
    }

    @Test
    @DisplayName("The winning score should be correctly calculated with the dummy data")
    fun playWithDummyData() {
        val score1 = play(9, 25)
        val score2 = play(10, 1618)
        val score3 = play(13, 7999)
        val score4 = play(17, 1104)
        val score5 = play(21, 6111)
        val score6 = play(30, 5807)
        assertThat(score1, `is`(32L))
        assertThat(score2, `is`(8317L))
        assertThat(score3, `is`(146373L))
        assertThat(score4, `is`(2764L))
        assertThat(score5, `is`(54718L))
        assertThat(score6, `is`(37305L))
    }

    @Test
    @DisplayName("The winning score should be correctly calculated with the first real data")
    fun playWithFirstRealData() {
        val (players, marbles) = parseInput(getInput(9).readLines().first())
        val score = play(players, marbles)
        assertThat(score, `is`(371284L))
    }

    @Test
    @DisplayName("The winning score should be correctly calculated with the second real data")
    fun playWithSecondRealData() {
        val (players, marbles) = parseInput(getInput(9).readLines().first())
        val score = play(players, marbles * 100)
        assertThat(score, `is`(3038972494L))
    }
}