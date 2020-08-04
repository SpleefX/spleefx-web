package io.github.spleefx.api

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableAsync
import java.util.concurrent.ExecutorService
import java.util.concurrent.ForkJoinPool

/***
 * Main class for the Spring application
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
         * Our own executor pool.
         */
        @JvmField
        val EXECUTOR = ForkJoinPool()

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(SpleefXAPI::class.java, *args)
            VersionController.LocalVersionReader.schedule()
        }

        /**
         * Runs the specified block in a coroutine
         */
        inline fun async(crossinline block: () -> Unit) {
            GlobalScope.launch {
                try {
                    block()
                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }
        }
    }
}