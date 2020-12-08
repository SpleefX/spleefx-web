package net.spleefx.api.stats

import io.lettuce.core.RedisFuture
import net.spleefx.api.redis.MappedRedisAccessor
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

object GameStats : MappedRedisAccessor("gameStats", 2) {

    fun addGame(info: String): CompletableFuture<String> {
        val id = getNextID()
        val future = CompletableFuture<String>()
        async {
            set(id, info.replace(whitespace, ""))
                    .thenRun { expire(id, TimeUnit.DAYS.toSeconds(15)) }
                    .thenRun { future.complete(id) }
        }
        return future
    }

    fun getGame(id: Any): RedisFuture<String> {
        return async { get(id.toString()) }
    }

}