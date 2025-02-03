package ru.normno.stream

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream

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
//        val bytes = FileInputStream(file).use {
//            it.readBytes()
//        }

        val stringBuilder = StringBuilder()

        FileInputStream(file).use {
            var byte = it.read()
            while (byte != -1) {
                stringBuilder.append(byte.toChar())
                byte = it.read()
            }
        }

        println(stringBuilder.toString())

        FileOutputStream(file).use { outputFile ->
            repeat(100_000) {
                outputFile.write("$it\n".encodeToByteArray())
            }
        }
    }
}