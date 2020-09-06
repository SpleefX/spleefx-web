package net.spleefx.api.docs

import net.spleefx.api.SpleefXAPI
import net.spleefx.api.util.content
import net.spleefx.api.util.delete
import java.io.File
import java.io.FileFilter
import java.io.FileNotFoundException
import java.util.concurrent.ConcurrentHashMap

object DocumentCache {

    internal val pages = ConcurrentHashMap<String, String>()

    fun loadAll() {
        for (file in SpleefXAPI.WIKI.listFiles(FileFilter { it.name.endsWith(".md") })!!) {
            load(file)
        }
    }

    fun getPage(name: String): String? {
        return pages[name]
    }

    fun search(query: String, titlesOnly: Boolean = false, ignoreCase: Boolean = false): List<String> {
        val found = ArrayList<String>()
        for (page in pages) {
            val search = if (titlesOnly) page.key else page.value
            if (search.contains(query, ignoreCase))
                found += page.key
        }
        return found
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