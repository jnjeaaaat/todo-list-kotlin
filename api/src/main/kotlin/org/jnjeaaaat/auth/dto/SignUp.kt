package org.jnjeaaaat.auth.dto

import org.jnjeaaaat.entity.Member

class SignUp {
    data class SignUpRequest(
        var uid: String? = null,
        var password: String? = null
    )

    data class SignUpResponse(
        var id: Long? = null
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