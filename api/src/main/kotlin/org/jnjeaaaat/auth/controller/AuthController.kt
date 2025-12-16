package org.jnjeaaaat.auth.controller

import org.jnjeaaaat.auth.dto.SignUp
import org.jnjeaaaat.auth.service.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(var authService: AuthService) {

    @PostMapping("/signup")
    fun signUp(@RequestBody request: SignUp.SignUpRequest): ResponseEntity<SignUp.SignUpResponse> =
        ResponseEntity.ok(
            authService.signUp(request)
        )
}