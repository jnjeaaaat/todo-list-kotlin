package org.jnjeaaaat.error

import jakarta.servlet.http.HttpServletRequest
import org.jnjeaaaat.CustomException
import org.jnjeaaaat.ErrorCode
import org.jnjeaaaat.ErrorResponse
import org.jnjeaaaat.FieldErrorDetails
import org.jnjeaaaat.LogUtils.Companion.logError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun handleCustomExceptions(request: HttpServletRequest, e: CustomException): ResponseEntity<ErrorResponse> {
        logError(request, e)

        return ResponseEntity
            .status(e.errorCode.httpStatus)
            .body(ErrorResponse.of(e.errorCode))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        request: HttpServletRequest,
        e: MethodArgumentNotValidException
    ): ResponseEntity<ErrorResponse> {
        logError(request, e)

        val fieldErrors = e.bindingResult.fieldErrors.map {
            FieldErrorDetails(
                field = it.field,
                reason = it.defaultMessage
            )
        }

        return ResponseEntity
            .badRequest()
            .body(
                ErrorResponse.of(
                    errorCode = ErrorCode.INVALID_INPUT_VALUE,
                    fieldErrors = fieldErrors
                )
            )
    }
}