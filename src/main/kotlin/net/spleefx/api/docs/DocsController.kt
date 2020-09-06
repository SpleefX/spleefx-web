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

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@RestController
class DocsController {

    @GetMapping("/wiki/search")
    fun search(): ModelAndView {
        return ModelAndView("search.html").addObject("pagesCount", DocumentCache.pages.size)
    }

    @GetMapping("/wiki/{name}")
    fun getDocumentRaw(@PathVariable name: String): ModelAndView {
        if (name.startsWith("_")) // pages that start with _ aren't actual pages. don't expose those :D
            return ModelAndView("errors/404.html")
        return DocumentCache.getPage(name).let {
            if (it == "404.html") return@let ModelAndView("errors/404.html")
            try {
                ModelAndView("wiki-template.html")
                        .addObject("pageTitle", name.replace('-', ' '))
                        .addObject("pageContent", it)
                        .addObject("pageID", name)
                        .addObject("sidebar", DocumentCache.getPage("_Sidebar"))
                        .addObject("footer", DocumentCache.getPage("_Footer"))
            } catch (t: Throwable) {
                ModelAndView("errors/404.html")
            }
        }
    }

    @GetMapping(path = ["/search"], produces = ["application/json"])
    fun search(@RequestParam ignoreCase: Boolean, @RequestParam titleOnly: Boolean, @RequestParam query: String): List<String> {
        println(query)
        return listOf("POG")
    }

}