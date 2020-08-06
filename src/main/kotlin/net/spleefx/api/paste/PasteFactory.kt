package net.spleefx.api.paste

import com.github.benmanes.caffeine.cache.AsyncLoadingCache
import com.github.benmanes.caffeine.cache.CacheLoader
import com.github.benmanes.caffeine.cache.Caffeine
import net.spleefx.api.SpleefXAPI
import java.io.File
import java.security.SecureRandom
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

object PasteFactory {

    /**
     * A list of all characters used in a generated paste ID
     */
    private val idCharacters: List<String> = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890".split("").toList()

    /**
     * The random used to generate IDs
     */
    private val idRandom: Random = SecureRandom()

    /**
     * The maximum ID length
     */
    private const val ID_LENGTH = 8

    /**
     * The asynchronous cache for loading pastes
     */
    private val cache: AsyncLoadingCache<String, String> = Caffeine.newBuilder()
            .expireAfterAccess(6, TimeUnit.HOURS)
            .executor(SpleefXAPI.EXECUTOR)
            .buildAsync(CacheLoader {
                try {
                    PasteCompressor.readGZIP(File(SpleefXAPI.SETTINGS.pasteSaveDirectory, it))
                } catch (e: InvalidPasteException) {
                    "Invalid paste: $it"
                }
            })

    /**
     * Creates a new paste
     *
     * @param text Paste text
     * @return A future for the paste ID
     */
    fun createPaste(text: String): CompletableFuture<String> {
        val future = CompletableFuture<String>()
        SpleefXAPI.runAsync {
            val id = generatePasteID()
            val file = File(SpleefXAPI.SETTINGS.pasteSaveDirectory, id)
            PasteCompressor.createGZIP(text, file)
            future.complete(id)
        }
        return future
    }

    /**
     * Reads the paste with the specified ID
     */
    fun readPaste(id: String): CompletableFuture<String> {
        return cache.get(id)
    }

    /**
     * Generates a pseudo-random paste ID on request.
     */
    private fun generatePasteID(): String {
        val id = StringBuilder()
        for (i in 0 until ID_LENGTH) {
            id.append(idCharacters[idRandom.nextInt(idCharacters.size)])
        }
        return id.toString()
    }

    /**
     * Thrown as a way to handle invalid pastes
     */
    class InvalidPasteException(id: String) : Exception(id)

}