package org.jnjeaaaat

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*


enum class ErrorCode(
    val httpStatus: HttpStatus,
    val message: String
) {

    DUPLICATED_UID(CONFLICT, "중복된 아이디 입니다."),
    INVALID_INPUT_VALUE(BAD_REQUEST, "유효하지 않은 입력 값입니다."),
}