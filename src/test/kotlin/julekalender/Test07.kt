package julekalender

import julekalender.Task07.Companion.calculateOrder
import julekalender.Task07.Companion.calculateTimeToComplete
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test07 {

    @Test
    @DisplayName("The correct order should be calculated with the dummy data")
    fun calculateOrderDummyData() {
        val order = calculateOrder(listOf(
                "Step C must be finished before step A can begin.",
                "Step C must be finished before step F can begin.",
                "Step A must be finished before step B can begin.",
                "Step A must be finished before step D can begin.",
                "Step B must be finished before step E can begin.",
                "Step D must be finished before step E can begin.",
                "Step F must be finished before step E can begin."
        ))
        assertThat(order, `is`("CABDFE"))
    }

    @Test
    @DisplayName("The correct order should be calculated with the real data")
    fun calculateOrderRealData() {
        val order = calculateOrder(getInput(7).readLines())
        assertThat(order, `is`("ABDCJLFMNVQWHIRKTEUXOZSYPG"))
    }

    @Test
    @DisplayName("The correct completion time should be calculated with the dummy data")
    fun calculateTimeToCompleteDummyData() {
        val time = calculateTimeToComplete(listOf(
                "Step C must be finished before step A can begin.",
                "Step C must be finished before step F can begin.",
                "Step A must be finished before step B can begin.",
                "Step A must be finished before step D can begin.",
                "Step B must be finished before step E can begin.",
                "Step D must be finished before step E can begin.",
                "Step F must be finished before step E can begin."
        ), 2, 0)
        assertThat(time, `is`(15))
    }

    @Test
    @DisplayName("The correct completion time should be calculated with the real data")
    fun calculateTimeToCompleteRealData() {
        val time = calculateTimeToComplete(getInput(7).readLines(), 5, 60)
        assertThat(time, `is`(896))
    }
}