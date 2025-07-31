package com.farmfreshhub.entity

import jakarta.persistence.*

@Entity
@Table(name = "product_images")
data class ProductImage(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val imageId: Int = 0,

    @Column(name = "product_id")
    val productId: Int = 0,

    val imageUrl: String = ""
)
