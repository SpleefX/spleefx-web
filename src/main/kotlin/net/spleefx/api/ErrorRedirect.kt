package net.spleefx.api

import org.springframework.boot.web.servlet.error.ErrorController
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import javax.servlet.RequestDispatcher
import javax.servlet.http.HttpServletRequest

@Controller
class ErrorRedirect : ErrorController {

    override fun getErrorPath(): String {
        return "/error"
    }

    @RequestMapping("/error")
    fun handleError(request: HttpServletRequest): String {
        val status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE)
        if (status != null) {
            return "errors/" + when (status.toString().toInt()) {
                HttpStatus.NOT_FOUND.value() -> "404"
                HttpStatus.INTERNAL_SERVER_ERROR.value() -> "500"
                HttpStatus.FORBIDDEN.value() -> "403"
                else -> "error"
            }
        }
        return "errors/error"
    }
}