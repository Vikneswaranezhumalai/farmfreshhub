package com.farmfreshhub.entity

import jakarta.persistence.*

@Entity
@Table(name = "order_items")
data class OrderItem(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderItemId: Int = 0,

    @Column(name = "order_id")
    val orderId: Int = 0,

    @Column(name = "product_id")
    val productId: Int = 0,

    val quantity: Double = 0.0,
    val pricePerUnit: Double = 0.0
)
