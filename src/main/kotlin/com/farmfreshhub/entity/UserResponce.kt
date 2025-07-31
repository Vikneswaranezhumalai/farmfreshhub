package com.farmfreshhub.entity

data class UserResponse(
    val success: Boolean,
    val message: String?,
    val user: User?,
    val token: String? = null // Always null for now
)

