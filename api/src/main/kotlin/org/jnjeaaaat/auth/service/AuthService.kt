package org.jnjeaaaat.auth.service

import org.jnjeaaaat.auth.dto.SignUp
import org.jnjeaaaat.entity.Member
import org.jnjeaaaat.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class AuthService(var memberRepository: MemberRepository) {

    fun signUp(request: SignUp.SignUpRequest): SignUp.SignUpResponse =
        SignUp.SignUpResponse.Companion.fromEntity(
            memberRepository.save(
                Member(
                    uid = request.uid,
                    password = request.password
                )
            )
        )
}