package org.jnjeaaaat.dto.member

import org.jnjeaaaat.entity.member.Member

class MemberInfo(
    val id: Long? = null,
    val uid: String? = null
) {
    companion object {
        fun fromEntity(member: Member): MemberInfo {
            return MemberInfo(
                id = member.id,
                uid = member.uid
            )
        }
    }
}