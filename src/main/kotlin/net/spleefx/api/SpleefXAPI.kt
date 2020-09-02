package net.spleefx.api

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.moltenjson.configuration.direct.DirectConfiguration
import net.moltenjson.json.JsonFile
import net.spleefx.api.VersionController.LocalVersionReader
import net.spleefx.api.util.IncrementingID
import org.apache.catalina.Context
import org.apache.catalina.connector.Connector
import org.apache.tomcat.util.descriptor.web.SecurityCollection
import org.apache.tomcat.util.descriptor.web.SecurityConstraint
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.servlet.server.ServletWebServerFactory
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

    @Bean
    fun servletContainer(): ServletWebServerFactory {
        val tomcat: TomcatServletWebServerFactory = object : TomcatServletWebServerFactory() {
            override fun postProcessContext(context: Context) {
                val securityConstraint = SecurityConstraint()
                securityConstraint.userConstraint = "CONFIDENTIAL"
                val collection = SecurityCollection()
                collection.addPattern("/*")
                securityConstraint.addCollection(collection)
                context.addConstraint(securityConstraint)
            }
        }
        tomcat.addAdditionalTomcatConnectors(httpConnector)
        return tomcat
    }

    private val httpConnector: Connector
        get() {
            val connector = Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL)
            connector.scheme = "http"
            connector.port = 8080
            connector.secure = false
            connector.redirectPort = 443
            return connector
        }

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
        val DIR = File("/var/lib/data/")

        /**
         * The config file
         */
        @JvmField
        val CONFIG: DirectConfiguration = DirectConfiguration.of(JsonFile.of(DIR, "config.json"))

        init {
            DIR.mkdirs()
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
            LocalVersionReader.schedule()
            IncrementingID.schedule()
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

        inline fun <R> supplyAsync(crossinline task: () -> R): CompletableFuture<R> {
            val future = CompletableFuture<R>()
            GlobalScope.launch {
                try {
                    future.complete(task())
                } catch (t: Throwable) {
                    t.printStackTrace()
                    future.obtrudeException(t)
                }
            }
            return future
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