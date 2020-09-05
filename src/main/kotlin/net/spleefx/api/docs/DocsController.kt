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
package net.spleefx.api.docs

import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.util.concurrent.CompletableFuture

@RestController
class DocsController {

    @Async
    @GetMapping("/wiki/{name}")
    fun getDocumentRaw(@PathVariable name: String): CompletableFuture<ModelAndView> {
        if (name.startsWith("_")) // pages that start with _ aren't actual pages. don't expose those :D
            return CompletableFuture.completedFuture(ModelAndView("errors/404.html"))
        return DocumentCache.readPage(name).thenApply {
            if (it == "404.html") return@thenApply ModelAndView("errors/404.html")
            try {
                ModelAndView("wiki-template.html")
                        .addObject("pageTitle", name.replace('-', ' ')).addObject("pageContent", it)
                        .addObject("sidebar", DocumentCache.SIDEBAR)
                        .addObject("footer", DocumentCache.FOOTER)
            } catch (t: Throwable) {
                ModelAndView("errors/404.html")
            }
        }
    }

    @Async
    @GetMapping("/wiki_sidebar")
    fun getSidebarRaw(): CompletableFuture<String> {
        return DocumentCache.readPage("_Sidebar")
    }

}