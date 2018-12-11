package julekalender


fun main(args: Array<String>) {
    first()
    second()
}

fun first() {
    println("Frequency: ${getInput(1).readLines().map { s -> s.toInt() }.sum()}")
}

fun second() {
    val lines = getInput(1).readLines()

    var frequency = 0
    val encountered = mutableSetOf<Int>()

    generateSequence(0) { n -> n + 1 }
            .map { i -> lines[i % lines.size].toInt() }
            .takeWhile { encountered.add(frequency) }
            .forEach { n -> frequency += n }

    println("First duplicate frequency: $frequency")
}