package julekalender

import main.julekalender.Task2.Companion.calculateChecksum
import main.julekalender.Task2.Companion.findCommonLettersForPrototypeBoxes
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test2 {

    @Test
    @DisplayName("Checksum should be correctly calculated with the dummy data")
    fun testCalculateChecksumDummyData() {
        val checksum = calculateChecksum(listOf("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"))
        assertThat(checksum, `is`(12))
    }

    @Test
    @DisplayName("Checksum should be correctly calculated with the real data")
    fun testCalculateChecksumRealData() {
        val checksum = calculateChecksum(getInput(2).readLines())
        assertThat(checksum, `is`(8398))
    }

    @Test
    @DisplayName("The correct prototype should be found with the dummy data")
    fun testFindProtoypeBoxDummyData() {
        val answer = findCommonLettersForPrototypeBoxes(listOf("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz"))
        assertThat(answer, `is`("fgij"))
    }

    @Test
    @DisplayName("The correct prototype should be found with the real data")
    fun testFindProtoypeBoxRealData() {
        val answer = findCommonLettersForPrototypeBoxes(getInput(2).readLines())
        assertThat(answer, `is`("hhvsdkatysmiqjxunezgwcdpr"))
    }
}