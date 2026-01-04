package org.jnjeaaaat

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*


enum class ErrorCode(
    val httpStatus: HttpStatus,
    val message: String
) {

    DUPLICATED_UID(CONFLICT, "중복된 아이디 입니다."),

}