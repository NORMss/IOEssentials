package ru.normno.stream

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import kotlin.system.measureTimeMillis

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

        FileOutputStream(file).use { outputFile ->
            repeat(100_000) {
                outputFile.write("$it\n".encodeToByteArray())
            }
        }

        val stringBuilder = StringBuilder()
        val time1 = measureTimeMillis {
            FileInputStream(file).use {
                var byte = it.read()
                while (byte != -1) {
                    stringBuilder.append(byte.toChar())
                    byte = it.read()
                }
            }
        }
        val stringBuilder2 = StringBuilder()
        val time2 = measureTimeMillis {
            FileInputStream(file).bufferedReader().use { reader ->
                var byte = reader.read()
                while (byte != -1) {
                    stringBuilder2.append(byte.toChar())
                    byte = reader.read()
                }
            }
        }

        println("Time 1: $time1 ms.")
        println("Time 2: $time2 ms.")

//        println(stringBuilder.toString())
    }
}