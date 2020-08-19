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
package net.spleefx.api.util

import net.spleefx.api.SpleefXAPI
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.*

/**
 * A simple utility for reading embedded files inside the JAR.
 */
object LocalFile {

    /**
     * Reads the file with the specified name
     */
    fun read(name: String): String {
        return try {
            val reader = BufferedReader(InputStreamReader(SpleefXAPI::class.java.getResourceAsStream("/${name.replace('/', File.separatorChar)}")!!))
            var line: String?
            val builder = StringJoiner("\n")
            while ((reader.readLine().also { line = it }) != null)
                builder.add(line)
            builder.toString()
        } catch (e: Throwable) {
            e.printStackTrace()
            "404.html"
        }
    }
}