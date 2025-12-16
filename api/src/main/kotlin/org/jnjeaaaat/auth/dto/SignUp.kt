package org.jnjeaaaat.auth.dto

import org.jnjeaaaat.entity.Member

class SignUp {
    data class SignUpRequest(
        var uid: String,
        var password: String
    )

    data class SignUpResponse(
        var id: Long
    ) {
        companion object {
            fun fromEntity(member: Member): SignUpResponse =
                SignUpResponse(
                    id = member.id
                )
        }
    }
}