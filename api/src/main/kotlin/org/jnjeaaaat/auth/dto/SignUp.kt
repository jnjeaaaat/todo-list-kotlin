package org.jnjeaaaat.auth.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import org.jnjeaaaat.constant.ValidationPattern.PASSWORD_REGEX_STR
import org.jnjeaaaat.dto.member.MemberInfo

class SignUp {
    data class SignUpRequest(
        @field:NotBlank(message = "{member.uid.required}")
        @field:Size(min = 4, max = 20, message = "{member.uid.size}")
        val uid: String,

        @field:NotBlank(message = "{member.password.required}")
        @field:Pattern(regexp = PASSWORD_REGEX_STR, message = "{member.password.pattern}")
        val password: String
    )

    data class SignUpResponse(
        val id: Long? = null
    ) {
        companion object {
            fun fromInfo(info: MemberInfo): SignUpResponse {
                return SignUpResponse(
                    id = info.id
                )
            }
        }
    }
}