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
package net.spleefx.api.paste

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import net.spleefx.api.SpleefXAPI
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import java.net.URI
import java.util.concurrent.CompletableFuture

/**
 * Controller for paste endpoints mappings
 */
@Controller
class PasteController {

    /**
     * Returns the static HTML page for creating a paste
     */
    @RequestMapping("/paste")
    fun index(): String {
        return "paste.html"
    }

    /**
     * Creates a paste through the POST request.
     */
    @Async
    @PostMapping(value = ["/paste"], consumes = ["application/json"], produces = ["application/json"])
    fun createPaste(@RequestBody paste: PasteBody): CompletableFuture<ResponseEntity<String>> {
        return PasteFactory.createPaste(paste.paste).thenApply { PasteResponse(it) }.thenApply { p ->
            try {
                return@thenApply ResponseEntity(SpleefXAPI.MAPPER.writeValueAsString(p), HttpStatus.OK)
            } catch (e: JsonProcessingException) {
                e.printStackTrace()
                throw RuntimeException(e)
            }
        }
    }

    /**
     * Views a paste through the GET request.
     */
    @Async
    @RequestMapping(path = ["/paste/{pasteId}"], produces = ["text/plain"])
    fun viewPaste(@PathVariable pasteId: String): CompletableFuture<ResponseEntity<String>> {
        return if (pasteId.isEmpty() || pasteId.contains("paste")) { // blame spring for not redirecting /paste/ to /paste.
            CompletableFuture.completedFuture(ResponseEntity.status(HttpStatus.FOUND).location(URI.create("/paste")).build())
        } else try {
            PasteFactory.readPaste(pasteId).thenApply { ResponseEntity(it, HttpStatus.OK) }
        } catch (e: PasteFactory.InvalidPasteException) {
            CompletableFuture.completedFuture(ResponseEntity("Invalid paste: " + e.message, HttpStatus.BAD_REQUEST))
        }
    }
}