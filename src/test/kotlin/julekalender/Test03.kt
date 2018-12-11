package julekalender

import main.julekalender.Task03.Companion.countConflictingSquares
import main.julekalender.Task03.Companion.findClaimWithoutOverlap
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test03 {

    @Test
    @DisplayName("Count should be correctly calculated with the dummy data")
    fun testCountDummyData() {
        val count = countConflictingSquares(listOf("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2"))
        assertThat(count, `is`(4))
    }

    @Test
    @DisplayName("Count should be correctly calculated with the real data")
    fun testCountRealData() {
        val count = countConflictingSquares(getInput(3).readLines())
        assertThat(count, `is`(96569))
    }

    @Test
    @DisplayName("The correct claim should be found with the real data")
    fun testFindClaimRealData() {
        val count = findClaimWithoutOverlap(getInput(3).readLines())
        assertThat(count, `is`(1023))
    }
}