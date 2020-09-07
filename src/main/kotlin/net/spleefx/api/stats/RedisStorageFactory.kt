package net.spleefx.api.stats

import io.lettuce.core.RedisClient
import io.lettuce.core.api.StatefulRedisConnection
import net.spleefx.api.SpleefXAPI
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

/**
 * A simple wrapper for Redis calls to be ran in asynchronous context.
 */
class RedisStorageFactory {

    /**
     * The internal Redis client
     */
    private val redisClient: StatefulRedisConnection<String, String> = RedisClient.create("redis://" + SpleefXAPI.CONFIG.getString("redisIP") + "/2").connect()

    /**
     * Updates the specified key -> value asynchronously
     */
    operator fun set(key: Any, value: String) {
        val k = key.toString()
        with(redisClient.async()) {
            set(k, value)
            expire(k, TimeUnit.DAYS.toSeconds(15))
        }
    }

    /**
     * Returns the value mapping to the specified key asynchronously. May be null.
     */
    operator fun get(key: Any): CompletableFuture<String?> {
        return redisClient.async()[key.toString()].toCompletableFuture()
    }

    /**
     * Executes the save command
     */
    fun save() {
        redisClient.sync().save()
    }

    /**
     * Executes the save command asynchronously
     */
    fun asyncSave() {
        redisClient.async().save()
    }

}