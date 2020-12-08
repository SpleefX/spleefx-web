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
import net.spleefx.api.paste.PasteFactory
import net.spleefx.api.ratelimit.RateLimit
import net.spleefx.api.ratelimit.RequestsLimit
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
import javax.servlet.http.HttpServletRequest

@Controller
class DebugController {

    // 5 requests per minute per IP
    private val ratelimit = RequestsLimit { RateLimit(allows = 5, every = Duration.ofMinutes(1)) }

    /**
     * Returns the static HTML page for creating a paste
     */
    @RequestMapping("/debug")
    fun index(): String {
        return "404.html"
    }

    @Async
    @PostMapping(value = ["/createDebug"], consumes = ["application/json"], produces = ["application/json"])
    fun createReport(@RequestBody body: DebugBody, servlet: HttpServletRequest): CompletableFuture<ResponseEntity<DebugResponse>> {
        println(body.json)
        return ratelimit.consume(1, servlet) {
            DebugRedisAccessor.createReport(body.json).thenApply { ResponseEntity(it, HttpStatus.OK) }
        }
    }

    @Async
    @GetMapping(path = ["/debug"])
    fun viewPaste(@RequestParam id: String): CompletableFuture<ModelAndView> {
        return DebugRedisAccessor.getReport(id).thenApply {
            ModelAndView("view-debug.html").addObject("id", id).addObject("cont", it)
        }.toCompletableFuture()
    }
}