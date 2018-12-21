package julekalender

import julekalender.Task06.Companion.findLargestArea
import julekalender.Task06.Companion.findSizeOfAreaWithLocationsWithTotalDistanceBelowThreshold
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test06 {

    @Test
    @DisplayName("The largest area should be found with the dummy data")
    fun findLargestAreaDummyData() {
        val area = findLargestArea(listOf("1, 1", "1, 6", "8, 3", "3, 4", "5, 5", "8, 9"))
        assertThat(area, `is`(17))
    }

    @Test
    @DisplayName("The largest area should be found with the real data")
    fun findLargestAreaRealData() {
        val area = findLargestArea(getInput(6).readLines())
        assertThat(area, `is`(4398))
    }

    @Test
    @DisplayName("The size of the area containing all locations that have a total distance to all given coorinates " +
            "below the given threshold should be correctly calculated using the dummy data")
    fun findSizeOfAreaWithLocationsWithTotalDistanceBelowThresholdDummyData() {
        val area = findSizeOfAreaWithLocationsWithTotalDistanceBelowThreshold(listOf("1, 1", "1, 6", "8, 3", "3, 4", "5, 5", "8, 9"), 32)
        assertThat(area, `is`(16))
    }

    @Test
    @DisplayName("The size of the area containing all locations that have a total distance to all given coorinates " +
            "below the given threshold should be correctly calculated using the real data")
    fun findSizeOfAreaWithLocationsWithTotalDistanceBelowThresholdRealData() {
        val area = findSizeOfAreaWithLocationsWithTotalDistanceBelowThreshold(getInput(6).readLines(), 10000)
        assertThat(area, `is`(39560))
    }
}