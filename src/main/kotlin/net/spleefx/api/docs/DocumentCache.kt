package net.spleefx.api.docs

import com.github.benmanes.caffeine.cache.AsyncLoadingCache
import com.github.benmanes.caffeine.cache.CacheLoader
import com.github.benmanes.caffeine.cache.Caffeine
import net.spleefx.api.SpleefXAPI
import net.spleefx.api.util.LocalFile
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

object DocumentCache {

    private val cache: AsyncLoadingCache<String, String> = Caffeine.newBuilder()
            .executor(SpleefXAPI.EXECUTOR)
            .expireAfterAccess(6, TimeUnit.HOURS)
            .expireAfterWrite(6, TimeUnit.HOURS)
            .buildAsync(CacheLoader {
                LocalFile.read("docs/$it.md")
            })

    fun readPage(name: String): CompletableFuture<String> {
        return cache.get(name.replace(' ', '-'))
    }
}