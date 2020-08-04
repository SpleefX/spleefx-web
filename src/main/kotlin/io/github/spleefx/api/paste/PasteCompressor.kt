package io.github.spleefx.api.paste

import java.io.*
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

/**
 * A utility for reading and writing GZIP files
 */
object PasteCompressor {

    /**
     * Creates a GZIP
     */
    fun createGZIP(text: String, destination: File) {
        try {
            val written = FileOutputStream(destination)
            val zipped = GZIPOutputStream(written)
            zipped.write(text.toByteArray())
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
    fun readGZIP(compressedFile: File): String {
        val buffer = ByteArray(1024)
        return try {
            if (!compressedFile.exists()) throw PasteFactory.InvalidPasteException(compressedFile.name)
            val fileIn = FileInputStream(compressedFile)
            println(compressedFile.absolutePath)
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
}