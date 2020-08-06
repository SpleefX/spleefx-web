package io.github.spleefx.api

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.*

/***
 * Main class for the Spring application. Used mostly to schedule tasks and handle application
 * context stuff.
 */
@EnableAsync
@SpringBootApplication
class SpleefXAPI {

    /**
     * The task executor pool. This is scanned by Spring
     */
    @Bean
    fun taskExecutor(): ExecutorService = EXECUTOR

    companion object {

        /**
         * The mapper for JSON
         */
        @JvmField
        val MAPPER = ObjectMapper()

        @JvmField
        val SETTINGS: ConfigSettings = MAPPER.readValue(readConfig(), ConfigSettings::class.java)

        private fun readConfig(): String {
            val reader = BufferedReader(InputStreamReader(SpleefXAPI::class.java.getResourceAsStream("/config.json")))
            var line: String?
            val builder = StringBuilder()
            while ((reader.readLine().also { line = it }) != null)
                builder.append(line)
            return builder.toString()
        }

        /**
         * Our own executor pool.
         */
        @JvmField
        val EXECUTOR = ForkJoinPool()

        /**
         * Pool to schedule repeating tasks asynchronously
         */
        @JvmField
        val SCHEDULED: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

        /**
         * Runs the application
         */
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpleefXAPI::class.java, *args)
            VersionController.LocalVersionReader.schedule()
        }

        /**
         * Runs the specified block in the global scope coroutine
         *
         * @param task Task to run
         */
        inline fun runAsync(crossinline task: () -> Unit) {
            GlobalScope.launch {
                try {
                    task()
                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }
        }

        /**
         * Schedules the specified task for repeating asynchronously
         *
         * @param delay    Initial delay to wait before scheduling
         * @param interval Interval to repeat in
         * @param unit     Unit of the interval and delay
         * @param task     Task to repeat
         */
        inline fun scheduleAsync(delay: Long, interval: Long, unit: TimeUnit, crossinline task: () -> Unit) {
            SCHEDULED.scheduleAtFixedRate({
                try {
                    task()
                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }, delay, interval, unit)
        }
    }
}