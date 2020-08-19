package net.spleefx.api.stats

import net.spleefx.api.SpleefXAPI
import net.spleefx.api.util.IncrementingID
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

object GameStatsFactory {

    private val id = IncrementingID("gameStats")
    private val storageFactory = RedisStorageFactory()

    fun createGame(payload: String): Int {
        val id = id.nextID
        storageFactory[id] = payload
        return id
    }

    fun readGame(id: Int): CompletableFuture<String?> {
        return storageFactory[id]
    }

    fun schedule() {
        SpleefXAPI.scheduleAsync(1, 1, TimeUnit.HOURS) {
            storageFactory.asyncSave()
        }
    }

    fun save() = storageFactory.save()

}