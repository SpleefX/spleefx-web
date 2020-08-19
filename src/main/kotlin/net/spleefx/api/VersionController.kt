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

import net.spleefx.api.util.LocalFile
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit


/**
 * Controller for responding to version requests
 */
@RestController
class VersionController {

    /**
     * Views the version list in order.
     */
    @GetMapping("/api/version", produces = ["application/json"])
    fun versions(): String {
        return LocalVersionReader.versions
    }

    /**
     * Utility class to read the versions from the embedded file
     */
    object LocalVersionReader {

        /**
         * The standardized version response
         */
        @JvmField
        var versions: String = ""

        /**
         * Schedules the reading repeating task.
         */
        @JvmStatic
        fun schedule() {
            SpleefXAPI.scheduleAsync(0, 10, TimeUnit.MINUTES) {
                synchronized(versions) {
                    versions = LocalFile.read("versions.json")
                }
            }
        }
    }
}