package julekalender

import julekalender.Task10.Companion.findMessage
import main.julekalender.getInput
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Test10 {

    private val testInput = listOf(
            "position=< 9,  1> velocity=< 0,  2>",
            "position=< 7,  0> velocity=<-1,  0>",
            "position=< 3, -2> velocity=<-1,  1>",
            "position=< 6, 10> velocity=<-2, -1>",
            "position=< 2, -4> velocity=< 2,  2>",
            "position=<-6, 10> velocity=< 2, -2>",
            "position=< 1,  8> velocity=< 1, -1>",
            "position=< 1,  7> velocity=< 1,  0>",
            "position=<-3, 11> velocity=< 1, -2>",
            "position=< 7,  6> velocity=<-1, -1>",
            "position=<-2,  3> velocity=< 1,  0>",
            "position=<-4,  3> velocity=< 2,  0>",
            "position=<10, -3> velocity=<-1,  1>",
            "position=< 5, 11> velocity=< 1, -2>",
            "position=< 4,  7> velocity=< 0, -1>",
            "position=< 8, -2> velocity=< 0,  1>",
            "position=<15,  0> velocity=<-2,  0>",
            "position=< 1,  6> velocity=< 1,  0>",
            "position=< 8,  9> velocity=< 0, -1>",
            "position=< 3,  3> velocity=<-1,  1>",
            "position=< 0,  5> velocity=< 0, -1>",
            "position=<-2,  2> velocity=< 2,  0>",
            "position=< 5, -2> velocity=< 1,  2>",
            "position=< 1,  4> velocity=< 2,  1>",
            "position=<-2,  7> velocity=< 2, -2>",
            "position=< 3,  6> velocity=<-1, -1>",
            "position=< 5,  0> velocity=< 1,  0>",
            "position=<-6,  0> velocity=< 2,  0>",
            "position=< 5,  9> velocity=< 1, -2>",
            "position=<14,  7> velocity=<-2,  0>",
            "position=<-3,  6> velocity=< 2, -1>"
    )

    @Test
    @DisplayName("The time before the message appears should be correctly calculated for the dummy data")
    fun sumMetadataDummyData() {
        val (time, _) = findMessage(testInput)
        assertThat(time, `is`(3))
    }

    @Test
    @DisplayName("The time before the message appears should be correctly calculated for the real data")
    fun sumMetadataRealData() {
        val input = getInput(10).readLines()
        val (time, _) = findMessage(input)
        assertThat(time, `is`(10076))
    }

    @Test
    @DisplayName("The correct message should be found for the dummy data")
    fun findMessageDummyData() {
        val (_, message) = findMessage(testInput)

        val expected =
                "#...#..###\n" +
                "#...#...#.\n" +
                "#...#...#.\n" +
                "#####...#.\n" +
                "#...#...#.\n" +
                "#...#...#.\n" +
                "#...#...#.\n" +
                "#...#..###"

        assertThat(message, `is`(expected))
    }

    @Test
    @DisplayName("The correct message should be found for the real data")
    fun findMessageRealData() {
        val input = getInput(10).readLines()
        val (_, message) = findMessage(input)

        val expected =
                "#####...#####....####...######....##....######..#####...#####.\n" +
                "#....#..#....#..#....#.......#...#..#...#.......#....#..#....#\n" +
                "#....#..#....#..#............#..#....#..#.......#....#..#....#\n" +
                "#....#..#....#..#...........#...#....#..#.......#....#..#....#\n" +
                "#####...#####...#..........#....#....#..#####...#####...#####.\n" +
                "#..#....#....#..#.........#.....######..#.......#.......#.....\n" +
                "#...#...#....#..#........#......#....#..#.......#.......#.....\n" +
                "#...#...#....#..#.......#.......#....#..#.......#.......#.....\n" +
                "#....#..#....#..#....#..#.......#....#..#.......#.......#.....\n" +
                "#....#..#####....####...######..#....#..######..#.......#....."

        assertThat(message, `is`(expected))
    }
}