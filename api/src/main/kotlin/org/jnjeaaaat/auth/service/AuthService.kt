package org.jnjeaaaat.auth.service

import org.jnjeaaaat.exception.AuthException
import org.jnjeaaaat.ErrorCode.*
import org.jnjeaaaat.auth.dto.SignUp
import org.jnjeaaaat.entity.member.Member
import org.jnjeaaaat.logger
import org.jnjeaaaat.repository.MemberRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(var memberRepository: MemberRepository, var encoder: BCryptPasswordEncoder) {

    private val log = logger()

    fun signUp(request: SignUp.SignUpRequest): SignUp.SignUpResponse {

        validateSignup(request)

        val savedMember = memberRepository.save(
            Member(
                uid = request.uid,
                password = encoder.encode(request.password)
            )
        )

        log.info { "회원가입 성공 id : ${savedMember.id}" }

        return SignUp.SignUpResponse.fromEntity(savedMember)
    }

    private fun checkDuplicatedUid(uid: String) {
        if (memberRepository.existsByUid(uid)) {
            throw AuthException(DUPLICATED_UID)
        }
    }

    private fun validateSignup(request: SignUp.SignUpRequest) {
        checkDuplicatedUid(request.uid)
    }
}