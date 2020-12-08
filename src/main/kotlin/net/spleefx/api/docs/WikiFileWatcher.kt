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

import net.spleefx.api.SpleefXAPI
import java.io.IOException
import java.nio.file.FileSystems
import java.nio.file.Path
import java.nio.file.StandardWatchEventKinds.*
import java.nio.file.WatchEvent
import java.nio.file.WatchKey

@Suppress("UNCHECKED_CAST")
object WikiFileWatcher {

    private val directory = SpleefXAPI.WIKI.toPath()
    private val watcher = FileSystems.getDefault().newWatchService()

    fun watch() {
        SpleefXAPI.runAsync {
            while (true) {
                try {
                    val key: WatchKey = directory.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY)
                    for (event in key.pollEvents()) {
                        val kind = event.kind()
                        if (kind == OVERFLOW) continue

                        // The filename is the
                        // context of the event.
                        val ev: WatchEvent<Path> = event as WatchEvent<Path>
                        val filename: Path = ev.context()

                        // Resolve the filename against the directory.
                        // If the filename is "test" and the directory is "foo",
                        // the resolved name is "test/foo".
                        val child: Path = directory.resolve(filename)
                        if ((kind == ENTRY_CREATE) or (kind == ENTRY_MODIFY))
                            DocumentCache.load(child.toFile())
                        else
                            DocumentCache.pages.remove(child.toFile().nameWithoutExtension)
                    }
                } catch (x: IOException) {
                    System.err.println(x)
                }
            }
        }
    }

}