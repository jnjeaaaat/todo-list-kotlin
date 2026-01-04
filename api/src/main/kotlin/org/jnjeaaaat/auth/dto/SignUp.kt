package org.jnjeaaaat.auth.dto

import org.jnjeaaaat.entity.Member

class SignUp {
    data class SignUpRequest(
        val uid: String,
        val password: String
    )

    data class SignUpResponse(
        val id: Long? = null
    ) {

        companion object {
            fun fromEntity(member: Member): SignUpResponse {
                return SignUpResponse(
                    id = member.id
                )
            }
        }

    }
}