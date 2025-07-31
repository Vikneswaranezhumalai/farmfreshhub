package com.farmfreshhub.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Column
import java.sql.Timestamp

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val userId: Int = 0,

    val name: String = "",
    val email: String = "",
    val passwordHash: String = "",
    val userType: String = "",
    val phone: String? = null,
    val address: String? = null,

    @Column(name = "created_at")
    val createdAt: Timestamp? = null
)
