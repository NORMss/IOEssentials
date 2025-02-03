package ru.normno.stream

import java.io.File
import java.io.FileInputStream

class InputOutputStreams(
    file: File,
) {
//    private val inputStream = FileInputStream(file)

    init {
        //Not a safe option to read files
//        val bytes = inputStream.readBytes()
//
//        inputStream.close()

        //Safe option for reading files
        val bytes = FileInputStream(file).use {
            it.readBytes()
        }

        println(bytes.decodeToString())
    }
}