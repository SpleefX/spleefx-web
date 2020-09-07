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

import net.spleefx.api.util.content
import java.io.File
import kotlin.math.max

object Test {

    @JvmStatic
    fun main(args: Array<String>) {
        val content = File("D:\\var\\lib\\data\\Wiki", "Edit-arena-structure.md").content()
        val queryIndex = content.indexOf("rewards")
        var lookingForFirstSpace = true
        var lookingForLastSpace = false
        var startIndex = queryIndex
        var lastIndex = queryIndex
        var chars = 300
        for ((index, char) in content.substring(max(queryIndex - 300, 0)).withIndex()) {
            if (char == ' ') {
                if (lookingForFirstSpace) {
                    lookingForFirstSpace = false
                    startIndex = index
                    continue
                }
                if (lookingForLastSpace) {
                    lastIndex = index
                    break
                }
            }
            if (chars > 0) chars--
            if (chars <= 0) {
                lookingForLastSpace = true
            }
        }
        println("...${content.substring(startIndex, lastIndex)}...")
    }
}