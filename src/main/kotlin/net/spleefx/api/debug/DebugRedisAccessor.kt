/*
 * * Copyright 2020 github.com/ReflxctionDev
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
package net.spleefx.api.debug

import io.lettuce.core.RedisFuture
import net.spleefx.api.SpleefXAPI
import net.spleefx.api.redis.RedisAccessor
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit

object DebugRedisAccessor : RedisAccessor(databaseIndex = 3) {

    fun createReport(text: String): CompletableFuture<DebugResponse> {
        val id = UUID.randomUUID().toString().replace("-", "")
        val future = CompletableFuture<DebugResponse>()
        async {
            set(id, text.replace(whitespace, ""))
                    .thenRun { expire(id, TimeUnit.DAYS.toSeconds(15)) }
                    .thenRun { future.complete(DebugResponse(id)) }
        }
        return future
    }

    fun getReport(id: String): RedisFuture<String> = async { get(id) }

    fun schedule() = SpleefXAPI.scheduleAsync(1, 1, TimeUnit.HOURS) { save() }

}