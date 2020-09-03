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
package net.spleefx.api.stats

import net.spleefx.api.ratelimit.RateLimit
import net.spleefx.api.ratelimit.RequestsLimit
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView
import java.time.Duration
import java.util.concurrent.CompletableFuture
import javax.servlet.http.HttpServletRequest

@RestController
class StatsController {

    // 5 creations per minute per IP.
    private val rateLimit: RequestsLimit = RequestsLimit { RateLimit(5, Duration.ofMinutes(1)) }

    @Async
    @PostMapping("/addstats")
    fun createStatsPage(@RequestBody payload: String, servlet: HttpServletRequest): CompletableFuture<ResponseEntity<String>> {
        return rateLimit.consume(requestIP = servlet) {
            GameStats.addGame(payload).thenApply { ResponseEntity.ok(it) }
        }
    }

    @Async
    @GetMapping("/stats")
    fun displayStatsPage(@RequestParam("game") gameId: String): CompletableFuture<ModelAndView> {
        return GameStats.getGame(gameId.toInt()).thenApply {
            try {
                if (it == null)
                    ModelAndView("errors/404.html")
                else
                    ModelAndView("stats.html").addObject("id", gameId).addObject("payload", it)
            } catch (e: Throwable) {
                e.printStackTrace()
                ModelAndView("errors/500.html")
            }
        }.toCompletableFuture()
    }
}