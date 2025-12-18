package org.jnjeaaaat.auth.controller

import jakarta.servlet.http.HttpServletRequest
import org.jnjeaaaat.LogUtils.Companion.logInfo
import org.jnjeaaaat.auth.dto.SignUp
import org.jnjeaaaat.auth.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(var authService: AuthService) {

    @PostMapping("/signup")
    fun signUp(
        request: HttpServletRequest,
        @RequestBody signUpRequest: SignUp.SignUpRequest
    ): ResponseEntity<SignUp.SignUpResponse> {

        logInfo(request, "회원가입 요청")

        return ResponseEntity.ok(
            authService.signUp(signUpRequest)
        )
    }
}