package org.jnjeaaaat.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import org.jnjeaaaat.type.RoleType

@Entity
data class Member(
    @Column
    var uid: String,

    @Column
    var password: String,

    @Column
    var role: RoleType = RoleType.ROLE_USER,

    @Id @GeneratedValue(strategy = IDENTITY)
    var id: Long = 0L

) : BaseEntity()