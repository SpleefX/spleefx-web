package net.spleefx.api.redis

import net.spleefx.api.util.IncrementingID

/**
 * Represents a [RedisAccessor] with an [IncrementingID] to allow unique mapping
 */
open class MappedRedisAccessor(context: String, databaseIndex: Int) : RedisAccessor(databaseIndex) {
    protected val id = IncrementingID(context)

    fun getNextID(): String {
        return id.nextID.toString()
    }

}