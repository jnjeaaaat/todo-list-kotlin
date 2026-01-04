package org.jnjeaaaat

class AuthException: CustomException {

    constructor(errorCode: ErrorCode) : super(errorCode)
    constructor(errorCode: ErrorCode, message: String): super(errorCode, message)
}