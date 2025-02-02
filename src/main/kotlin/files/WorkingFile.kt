package ru.normno.files

import java.io.File
import java.sql.DriverManager.println

class WorkingFile {
    val file = File("build.gradle.kts")
    init {
        println(file.length())
    }
}