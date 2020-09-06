package net.spleefx.api.util

import java.io.File

fun File.content(): String {
    return LocalFile.fromFile(this)
}

fun String.delete(substring: String): String {
    return replace(substring, "")
}