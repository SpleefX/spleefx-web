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
package net.spleefx.api.ratelimit

import org.springframework.http.ResponseEntity
import java.util.Collections.synchronizedMap
import java.util.concurrent.CompletableFuture
import javax.servlet.http.HttpServletRequest

class RequestsLimit(private val createRateLimit: () -> RateLimit) {

    private val limits: MutableMap<String, RateLimit> = synchronizedMap(HashMap())

    fun <R> consume(
            tokens: Long = 1,
            requestServlet: HttpServletRequest,
            block: () -> CompletableFuture<ResponseEntity<R>>
    ): CompletableFuture<ResponseEntity<R>> {
        return getLimit(requestServlet).consume(tokens, block)
    }

    private fun getLimit(requestServlet: HttpServletRequest): RateLimit {
        return limits.computeIfAbsent(requestServlet.remoteAddr) { createRateLimit() }
    }

}