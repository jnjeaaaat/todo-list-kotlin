package org.jnjeaaaat.mapper

import org.jnjeaaaat.auth.dto.SignUp
import org.jnjeaaaat.dto.member.MemberCommand
import org.mapstruct.Mapper

@Mapper
interface MemberMapper {
    fun toCommand(request: SignUp.SignUpRequest): MemberCommand.SignUp
}