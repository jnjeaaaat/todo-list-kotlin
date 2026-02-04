package org.jnjeaaaat.service.auth

import org.jnjeaaaat.ErrorCode.*
import org.jnjeaaaat.dto.member.MemberCommand
import org.jnjeaaaat.dto.member.MemberInfo
import org.jnjeaaaat.entity.member.Member
import org.jnjeaaaat.exception.AuthException
import org.jnjeaaaat.logger
import org.jnjeaaaat.repository.MemberRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(val memberRepository: MemberRepository, val encoder: BCryptPasswordEncoder) {

    private val log = logger()

    fun signUp(command: MemberCommand.SignUp): MemberInfo {

        validateSignup(command)

        val savedMember = memberRepository.save(
            Member(
                uid = command.uid,
                password = encoder.encode(command.password)
            )
        )

        log.info { "회원가입 성공 id : ${savedMember.id}" }

        return MemberInfo.fromEntity(savedMember)
    }

    private fun checkDuplicatedUid(uid: String) {
        if (memberRepository.existsByUid(uid)) {
            throw AuthException(DUPLICATED_UID)
        }
    }

    private fun validateSignup(command: MemberCommand.SignUp) {
        checkDuplicatedUid(command.uid)
    }
}