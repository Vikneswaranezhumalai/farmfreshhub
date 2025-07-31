package com.farmfreshhub.entity

import jakarta.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "orders")
data class Order(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val orderId: Int = 0,

    @Column(name = "buyer_id")
    val buyerId: Int = 0,

    val orderDate: Timestamp? = null,
    val status: String = "",
    val totalAmount: Double = 0.0
)
