package org.jnjeaaaat.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import org.jnjeaaaat.type.RoleType

@Entity
class Member(
    @Column(unique = true)
    val uid: String?,

    @Column(length = 300)
    var password: String?,

    @Column
    @Enumerated(EnumType.STRING)
    var role: RoleType = RoleType.ROLE_USER,

    @Id @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null

) : BaseEntity()