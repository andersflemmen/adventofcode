package main.julekalender

import java.io.File
import java.nio.file.Paths

fun getInput(task: Int): File {
    return File("${Paths.get("").toAbsolutePath()}${File.separator}input${File.separator}${"%02d".format(task)}")
}