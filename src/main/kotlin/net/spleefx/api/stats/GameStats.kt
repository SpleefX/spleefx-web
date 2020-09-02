package net.spleefx.api.stats

import io.lettuce.core.RedisFuture
import net.spleefx.api.redis.MappedRedisAccessor
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

object GameStats : MappedRedisAccessor("gameStats", 2) {

    private val WHITESPACE_REGEX = Regex.fromLiteral("\\s")

    fun addGame(info: String): CompletableFuture<String> {
        val id = getNextID()
        val future = CompletableFuture<String>()
        async {
            set(id, info.replace(WHITESPACE_REGEX, ""))
                    .thenAccept { expire(id, TimeUnit.DAYS.toSeconds(15)) }
                    .thenAccept { future.complete(id) }
        }
        return future
    }

    fun getGame(id: Any): RedisFuture<String> {
        return async { get(id.toString()) }
    }

}