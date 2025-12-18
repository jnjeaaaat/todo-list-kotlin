package org.jnjeaaaat

import jakarta.servlet.http.HttpServletRequest

open class LogUtils {

    companion object {
        private val log = logger()

        var requestUri: String? = null
        var requestMethod: String? = null

        fun logInfo(request: HttpServletRequest, description: String) {
            requestUri = request.requestURI
            requestMethod = request.method

            log.info { "[${requestUri}] ${requestMethod} : ${description}" }
        }

        fun logError(request: HttpServletRequest, e: Exception) {
            requestUri = request.requestURI
            requestMethod = request.method

            log.error { "[${requestUri}] ${requestMethod} : ${e.message}" }
        }
    }
}