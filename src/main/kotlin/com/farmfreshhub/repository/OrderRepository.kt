
package com.farmfreshhub.repository

import com.farmfreshhub.entity.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository : JpaRepository<Order, Int> {
    fun findByBuyerId(buyerId: Int): List<Order>
}
