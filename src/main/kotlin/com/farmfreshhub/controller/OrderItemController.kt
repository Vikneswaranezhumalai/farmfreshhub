package com.farmfreshhub.controller

import com.farmfreshhub.entity.OrderItem
import com.farmfreshhub.repository.OrderItemRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders/{orderId}/items")
class OrderItemController(private val orderItemRepository: OrderItemRepository) {

    @GetMapping
    fun getItems(@PathVariable orderId: Int): List<OrderItem> =
        orderItemRepository.findByOrderId(orderId)

    @PostMapping
    fun addItem(@PathVariable orderId: Int, @RequestBody item: OrderItem): OrderItem =
        orderItemRepository.save(item.copy(orderId = orderId))
}
