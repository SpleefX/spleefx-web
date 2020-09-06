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
package net.spleefx.api

import net.spleefx.api.docs.DocumentCache
import org.springframework.scheduling.annotation.Async
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.util.concurrent.CompletableFuture


@RestController
class RedirectController {

    @GetMapping(value = ["/discord"])
    fun discord(): ModelAndView {
        return createRedirect("https://discord.gg/uwf72ZN")
    }

    @GetMapping(value = ["/spigot"])
    fun spigot(): ModelAndView {
        return createRedirect("https://www.spigotmc.org/resources/73093/")
    }

    @GetMapping("/wiki")
    fun wiki(): ModelAndView {
        return DocumentCache.getPage("Home")
                .let {
                    ModelAndView("wiki-template.html")
                            .addObject("pageTitle", "Home")
                            .addObject("pageContent", it)
                            .addObject("sidebar", DocumentCache.getPage("_Sidebar"))
                            .addObject("footer", DocumentCache.getPage("_Footer"))
                }
    }

    @GetMapping("/github")
    fun gitHub(): ModelAndView {
        return createRedirect("https://github.com/SpleefX/")
    }

    private fun createRedirect(url: String): ModelAndView {
        return ModelAndView("redirect:$url")
    }

}