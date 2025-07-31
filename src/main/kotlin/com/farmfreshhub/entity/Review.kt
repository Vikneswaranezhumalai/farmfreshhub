package com.farmfreshhub.entity

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "reviews")
data class Review(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val reviewId: Int = 0,

    @Column(name = "product_id")
    val productId: Int = 0,

    @Column(name = "user_id")
    val userId: Int = 0,

    val rating: Int = 0,
    val comment: String? = null,
    val createdAt: Timestamp? = null
)
