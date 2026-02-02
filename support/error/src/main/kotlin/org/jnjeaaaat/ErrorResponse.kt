package org.jnjeaaaat

import com.fasterxml.jackson.annotation.JsonInclude

class ErrorResponse(
    val errorCode: ErrorCode,
    val message: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val fieldErrors: List<FieldErrorDetails>? = null
) {

    companion object {
        fun of(errorCode: ErrorCode): ErrorResponse {
            return ErrorResponse(errorCode, errorCode.message)
        }

        fun of(errorCode: ErrorCode, fieldErrors: List<FieldErrorDetails>): ErrorResponse {
            return ErrorResponse(errorCode, errorCode.message, fieldErrors)
        }
    }
}

data class FieldErrorDetails(
    val field: String,
    val reason: String? = "Invalid value"
)