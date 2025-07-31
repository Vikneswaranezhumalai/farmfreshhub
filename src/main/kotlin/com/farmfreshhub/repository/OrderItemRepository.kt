package com.farmfreshhub.repository

import com.farmfreshhub.entity.OrderItem
import org.springframework.data.jpa.repository.JpaRepository

interface OrderItemRepository : JpaRepository<OrderItem, Int> {
    fun findByOrderId(orderId: Int): List<OrderItem>
}

