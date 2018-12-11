package julekalender

import julekalender.Task1.Companion.calculateFrequency
import julekalender.Task1.Companion.findRepeatedFrequency
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test01 {

    @Test
    @DisplayName("Frequency should be correctly calculated with the dummy data")
    fun testCalculateFrequencyDummyData() {
        val frequency = calculateFrequency(listOf("+1", "-2", "+3", "+1"))
        assertThat(frequency, `is`(3))
    }

    @Test
    @DisplayName("Frequency should be correctly calculated with the real data")
    fun testCalculateFrequencyRealData() {
        val frequency = calculateFrequency(getInput(1).readLines())
        assertThat(frequency, `is`(493))
    }

    @Test
    @DisplayName("First repeated requency should be calculated correctly with the dummy data")
    fun testFindRepeatedFrequencyDummyData() {
        val repeated1 = findRepeatedFrequency(listOf("+1", "-1"))
        val repeated2 = findRepeatedFrequency(listOf("+3", "+3", "+4", "-2", "-4"))
        val repeated3 = findRepeatedFrequency(listOf("-6", "+3", "+8", "+5", "-6"))
        val repeated4 = findRepeatedFrequency(listOf("+7", "+7", "-2", "-7", "-4"))
        assertThat(repeated1, `is`(0))
        assertThat(repeated2, `is`(10))
        assertThat(repeated3, `is`(5))
        assertThat(repeated4, `is`(14))
    }

    @Test
    @DisplayName("First repeated requency should be calculated correctly with the real data")
    fun testFindRepeatedFrequencyRealData() {
        val repeated = findRepeatedFrequency(getInput(1).readLines())
        assertThat(repeated, `is`(413))
    }
}