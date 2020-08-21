package net.spleefx.api.util

import net.moltenjson.configuration.direct.DirectConfiguration
import net.moltenjson.json.JsonFile
import net.spleefx.api.SpleefXAPI
import java.util.concurrent.TimeUnit

/**
 * A simple utility to handle automated ID mapping
 */
class IncrementingID(private val context: String) {

    val nextID: Int
        get() {
            val id = config.getInt(context, 0) + 1
            config.set(context, id)
            return id
        }

    companion object {
        @JvmField
        val config: DirectConfiguration = DirectConfiguration.of(JsonFile.of(SpleefXAPI.DIR, "ids.json"))
        fun schedule() = SpleefXAPI.scheduleAsync(1, 1, TimeUnit.HOURS) {
            config.save(Throwable::printStackTrace)
        }
    }
}

private fun DirectConfiguration.getInt(identifier: String, def: Int): Int {
    val j = content.get(identifier) ?: return def
    return j.asInt
}