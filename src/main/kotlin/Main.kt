package ru.normno

import ru.normno.files.WorkingFile
import ru.normno.stream.InputOutputStreams
import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val folder = File("hello/test")
    val file = File(folder, "numbers.txt")

    WorkingFile(folder, file)

    InputOutputStreams(file)
}