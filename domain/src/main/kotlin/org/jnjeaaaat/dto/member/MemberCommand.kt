package org.jnjeaaaat.dto.member

sealed class MemberCommand {
    data class SignUp(val uid: String, val password: String) : MemberCommand()
}