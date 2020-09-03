package net.spleefx.api.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler
import java.util.*

@Configuration
class FaviconConfiguration {
    @Bean
    fun customFaviconHandlerMapping(): SimpleUrlHandlerMapping {
        val mapping = SimpleUrlHandlerMapping()
        mapping.setOrder(Int.MIN_VALUE)
        mapping.setUrlMap(Collections.singletonMap(
                "/favicon.ico", faviconRequestHandler()))
        return mapping
    }

    @Bean
    protected fun faviconRequestHandler(): ResourceHttpRequestHandler {
        val requestHandler = ResourceHttpRequestHandler()
        val classPathResource = ClassPathResource("com/baeldung/images/")
        val locations: List<Resource> = listOf(classPathResource)
        requestHandler.setLocations(locations)
        return requestHandler
    }
}