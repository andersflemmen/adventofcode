package julekalender

import julekalender.Task08.Companion.sumMetadata
import julekalender.Task08.Companion.calculateRootValue
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test08 {

    @Test
    @DisplayName("The correct metadata sum should be calculated with the dummy data")
    fun sumMetadataDummyData() {
        val sum = sumMetadata("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2")
        assertThat(sum, `is`(138))
    }

    @Test
    @DisplayName("The correct metadata sum should be calculated with the real data")
    fun sumMetadataRealData() {
        val sum = sumMetadata(getInput(8).readLines()[0])
        assertThat(sum, `is`(36027))
    }

    @Test
    @DisplayName("The correct root value should be calculated with the dummy data")
    fun calculateRootValueDummyData() {
        val rootValue = calculateRootValue("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2")
        assertThat(rootValue, `is`(66))
    }

    @Test
    @DisplayName("The correct root value should be calculated with the real data")
    fun calculateRootValueRealData() {
        val rootValue = calculateRootValue(getInput(8).readLines()[0])
        assertThat(rootValue, `is`(23960))
    }
}