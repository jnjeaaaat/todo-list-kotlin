package org.jnjeaaaat.exception

import org.jnjeaaaat.CustomException
import org.jnjeaaaat.ErrorCode

class AuthException : CustomException {

    constructor(errorCode: ErrorCode) : super(errorCode)
    constructor(errorCode: ErrorCode, message: String) : super(errorCode, message)
}