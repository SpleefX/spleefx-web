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

import io.github.bucket4j.Bandwidth
import io.github.bucket4j.Bucket
import io.github.bucket4j.Bucket4j
import io.github.bucket4j.Refill
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit


/**
 * A simple ratelimiter that implements the token bucket strategy.
 *
 * See [https://en.wikipedia.org/wiki/Token_bucket]
 */
class RateLimit(capacity: Long, every: Duration) {

    /**
     * The inner bucket
     */
    private val bucket: Bucket = Bucket4j.builder().addLimit(Bandwidth.classic(capacity, Refill.intervally(capacity, every))).build()

    /**
     * Attempts to consume 1 token from the bucket, otherwise returns a [ResponseEntity] with a status code
     * of [HttpStatus.TOO_MANY_REQUESTS].
     *
     * Wrapped in completable futures because everything we use is in completable futures, so that reduces our headache.
     */
    fun <R> consume(tokens: Long = 1, block: () -> CompletableFuture<ResponseEntity<R>>): CompletableFuture<ResponseEntity<R>> {
        val probe = bucket.tryConsumeAndReturnRemaining(tokens)
        if (probe.isConsumed) {
            return block()
        }
        return CompletableFuture.completedFuture(
                ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                        .header("X-Rate-Limit-Retry-After-Milliseconds", TimeUnit.NANOSECONDS.toMillis(probe.nanosToWaitForRefill).toString())
                        .build())
    }
}