package julekalender

import main.julekalender.Task04.Companion.findGuardMostFrequentlyAsleep
import main.julekalender.Task04.Companion.findGuardWithMostMinutesAsleep
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test04 {

    @Test
    @DisplayName("The guard with the most minutes asleep and the minute it is most asleep should be found with the dummy data")
    fun findGuardWithMostMinutesAsleepDummyData() {
        val answer = findGuardWithMostMinutesAsleep(listOf(
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-05 00:45] falls asleep",
                "[1518-11-05 00:55] wakes up"
        ))
        assertThat(answer, `is`(240))
    }

    @Test
    @DisplayName("The guard with the most minutes asleep and the minute it is most asleep should be found with the real data")
    fun findGuardWithMostMinutesAsleepRealData() {
        val answer = findGuardWithMostMinutesAsleep(getInput(4).readLines())
        assertThat(answer, `is`(35623))
    }

    @Test
    @DisplayName("The guard that is most frequently asleep on the same minute and that minute should be found with the dummy data")
    fun findGuardMostFrequentlyAsleepDummyData() {
        val answer = findGuardMostFrequentlyAsleep(listOf(
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-05 00:45] falls asleep",
                "[1518-11-05 00:55] wakes up"
        ))
        assertThat(answer, `is`(4455))
    }

    @Test
    @DisplayName("The guard that is most frequently asleep on the same minute and that minute should be found with the real data")
    fun findGuardMostFrequentlyAsleepRealData() {
        val answer = findGuardMostFrequentlyAsleep(getInput(4).readLines())
        assertThat(answer, `is`(23037))
    }
}