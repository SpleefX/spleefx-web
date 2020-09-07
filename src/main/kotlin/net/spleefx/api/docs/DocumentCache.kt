package net.spleefx.api.docs

import net.spleefx.api.SpleefXAPI
import net.spleefx.api.util.content
import net.spleefx.api.util.delete
import java.io.File
import java.io.FileFilter
import java.io.FileNotFoundException
import java.util.concurrent.ConcurrentHashMap
import kotlin.math.max

object DocumentCache {

    val pages = ConcurrentHashMap<String, String>()

    fun loadAll() {
        for (file in SpleefXAPI.WIKI.listFiles(FileFilter { it.name.endsWith(".md") })!!) {
            load(file)
        }
    }

    fun getPage(name: String): String? {
        return pages[name]
    }

    fun search(query: String, titlesOnly: Boolean = false, ignoreCase: Boolean = true): Map<String, String> {
        val found = LinkedHashMap<String, String>()
        for (page in pages) {
            if (page.key == "Home" || page.key.startsWith("_")) continue // don't search these pages
            val search = if (titlesOnly) page.key else page.value
            if (search.contains(query, ignoreCase))
                if (titlesOnly) found[page.key] = page.key
                else found[page.key] = computeDescription(page.value, query, ignoreCase)
        }
        return found
    }

    private fun computeDescription(content: String, query: String, ignoreCase: Boolean): String {
        val queryIndex = content.indexOf(query, ignoreCase = ignoreCase)
        var lookingForFirstSpace = true
        var lookingForLastSpace = false
        var startIndex = queryIndex
        var lastIndex = queryIndex
        var chars = 350
        for ((index, char) in content.substring(max(queryIndex - 340, 0)).withIndex()) {
            if (char == ' ') {
                if (lookingForFirstSpace) {
                    lookingForFirstSpace = false
                    startIndex = index
                    continue
                }
                if (lookingForLastSpace) {
                    lastIndex = index
                    break
                }
            }
            if (chars > 0) chars--
            if (chars <= 0) {
                lookingForLastSpace = true
            }
        }
        return "...${content.substring(startIndex, lastIndex)}..."
    }

    fun load(page: File) {
        try {
            val name = page.nameWithoutExtension
            if (name.startsWith("_"))
                pages[name] = page.content().delete("<br>")
            else
                pages[name] = page.content()
        } catch (ignored: FileNotFoundException) {

        }
    }

}