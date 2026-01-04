package org.jnjeaaaat.error

import jakarta.servlet.http.HttpServletRequest
import org.jnjeaaaat.CustomException
import org.jnjeaaaat.ErrorResponse
import org.jnjeaaaat.LogUtils.Companion.logError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun handleAllExceptions(request: HttpServletRequest, e: CustomException): ResponseEntity<ErrorResponse> {
        logError(request, e)

        return ResponseEntity
            .status(e.errorCode.httpStatus.value())
            .body(
                ErrorResponse(
                    errorCode = e.errorCode,
                    message = e.message
                )
            )
    }
}