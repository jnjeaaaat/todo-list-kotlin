package org.jnjeaaaat.auth.controller

import jakarta.servlet.http.HttpServletRequest
import jakarta.validation.Valid
import org.jnjeaaaat.LogUtils.Companion.logInfo
import org.jnjeaaaat.auth.dto.SignUp
import org.jnjeaaaat.mapper.MemberMapper
import org.jnjeaaaat.service.auth.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    private val authService: AuthService,
    private val memberMapper: MemberMapper
) {

    @PostMapping("/signup")
    fun signUp(
        request: HttpServletRequest,
        @RequestBody @Valid signUpRequest: SignUp.SignUpRequest
    ): ResponseEntity<SignUp.SignUpResponse> {

        logInfo(request, "회원가입 요청")

        return ResponseEntity.ok(
            SignUp.SignUpResponse.fromInfo(
                authService.signUp(
                    memberMapper.toCommand(signUpRequest)
                )
            )
        )
    }
}