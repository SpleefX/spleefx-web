package net.spleefx.api.util

import net.spleefx.api.paste.PasteFactory
import java.io.*
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

/**
 * Creates a GZIP
 */
fun String.createGZIP(destination: File) {
    try {
        val written = FileOutputStream(destination)
        val zipped = GZIPOutputStream(written)
        zipped.write(toByteArray())
        zipped.finish()
        written.close()
        zipped.close()
    } catch (ex: IOException) {
        ex.printStackTrace()
    }
}

/**
 * Reads the GZIP text from the specified file
 */
fun File.readGZIP(): String {
    val buffer = ByteArray(1024)
    return try {
        if (!exists()) throw PasteFactory.InvalidPasteException(name)
        val fileIn = FileInputStream(this)
        val gZIPInputStream = GZIPInputStream(fileIn)
        var beingRead: Int
        val bytes = ByteArrayOutputStream()
        while (gZIPInputStream.read(buffer).also { beingRead = it } > 0) {
            bytes.write(buffer, 0, beingRead)
        }
        gZIPInputStream.close()
        bytes.close()
        String(bytes.toByteArray())
    } catch (ex: IOException) {
        ex.printStackTrace()
        throw IllegalStateException(ex)
    }
}