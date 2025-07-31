
package com.farmfreshhub.entity

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "products")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val productId: Int = 0,

    @Column(name = "farmer_id")
    val farmerId: Int = 0,
    val name: String = "",
    @Column(name = "category_id")
    val categoryId: Int? = null,
    val description: String? = null,
    val pricePerUnit: Double = 0.0,
    val availableQty: Double = 0.0,
    val unit: String = "",
    val createdAt: Timestamp? = null
)
