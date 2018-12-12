package julekalender

import main.julekalender.Task05.Companion.findBestPolymerWithoutElement
import main.julekalender.Task05.Companion.reduce
import main.julekalender.Task05.Companion.removeElementAndReduce
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test05 {

    @Test
    @DisplayName("Polymer should be correctly reduced with dummy data")
    fun reducePolymerDummyData() {
        val result1 = reduce("aA")
        val result2 = reduce("abBA")
        val result3 = reduce("abAB")
        val result4 = reduce("aabAAB")
        val result5 = reduce("dabAcCaCBAcCcaDA")

        assertThat(result1, `is`(""))
        assertThat(result2, `is`(""))
        assertThat(result3, `is`("abAB"))
        assertThat(result4, `is`("aabAAB"))
        assertThat(result5, `is`("dabCBAcaDA"))
    }

    @Test
    @DisplayName("Polymer should be correctly reduced with real data")
    fun reducePolymerRealData() {
        val result = reduce(getInput(5).readLines().first())

        assertThat(result.length, `is`(11364))
    }

    @Test
    @DisplayName("The resulting polymer when removing an element before reducing it should be correct with dummy data")
    fun removeElementAndReducePolymer() {
        val result1 = removeElementAndReduce("dabAcCaCBAcCcaDA", 'a')
        val result2 = removeElementAndReduce("dabAcCaCBAcCcaDA", 'b')
        val result3 = removeElementAndReduce("dabAcCaCBAcCcaDA", 'c')
        val result4 = removeElementAndReduce("dabAcCaCBAcCcaDA", 'd')

        assertThat(result1, `is`("dbCBcD"))
        assertThat(result2, `is`("daCAcaDA"))
        assertThat(result3, `is`("daDA"))
        assertThat(result4, `is`("abCBAc"))
    }

    @Test
    @DisplayName("The best polymer with one element type should be found with real data")
    fun findBestPolymerWithoutElementRealData() {
        val result = findBestPolymerWithoutElement(getInput(5).readLines().first())

        assertThat(result.second.length, `is`(4212))
    }
}