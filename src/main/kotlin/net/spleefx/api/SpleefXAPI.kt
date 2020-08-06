package net.spleefx.api

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync
import java.io.File
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

        /**
         * The functioning directory for the API
         */
        @JvmField
        val DIR = File(System.getProperty("user.home"), "spleefx-web-api")

        /**
         * The pastes directory
         */
        @JvmField
        val PASTES = File(DIR, "pastes")

        init {
            PASTES.mkdirs()
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