/*
 * * Copyright 2019-2020 github.com/ReflxctionDev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.spleefx.api.redis

import io.lettuce.core.RedisClient
import io.lettuce.core.api.StatefulRedisConnection
import io.lettuce.core.api.async.RedisAsyncCommands
import io.lettuce.core.api.sync.RedisCommands
import net.spleefx.api.SpleefXAPI
import java.util.concurrent.TimeUnit

open class RedisAccessor(databaseIndex: Int) {

    protected val whitespace = Regex.fromLiteral("\\s")

    /**
     * The internal Redis client
     */
    val redisClient: StatefulRedisConnection<String, String> = RedisClient
            .create("redis://${SpleefXAPI.CONFIG.getString("redisIP")}/$databaseIndex")
            .connect()

    inline fun <R> async(block: RedisAsyncCommands<String, String>.() -> R): R {
        return redisClient.async().block()
    }

    inline fun <R> sync(block: RedisCommands<String, String>.() -> R): R {
        return redisClient.sync().block()
    }

    fun save(): Unit = sync { save() }

    init {
        println("Established connection to Redis #$databaseIndex.")
        SpleefXAPI.scheduleAsync(1, 1, TimeUnit.HOURS) {
            async { save() }
        }
    }
}