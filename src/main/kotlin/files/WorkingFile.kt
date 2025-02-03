package ru.normno.files

import java.io.File

class WorkingFile(
    folder: File,
    file: File,
) {
    init {
        if (!folder.exists()) {
            folder.mkdirs()
        }
        file.createNewFile()
        file.writeText("Hello, Kotlin!")
    }

    fun printFilesRecursively(
        folder: File = File("."),
        indentationLevel: Int = 0,
    ) {
        folder.listFiles()?.forEach { child ->
            val line = buildString {
                repeat(indentationLevel) {
                    append("  ")
                }
                append("─ ${child.name}")
            }
            println(line)
            if (child.isDirectory) {
                printFilesRecursively(child, indentationLevel + 1)
            }
        }
    }
}