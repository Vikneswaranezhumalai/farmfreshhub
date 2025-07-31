package com.farmfreshhub.controller

import com.farmfreshhub.entity.Order
import com.farmfreshhub.repository.OrderRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/orders")
class OrderController(private val orderRepository: OrderRepository) {

    @GetMapping
    fun getAll(): List<Order> = orderRepository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Order? = orderRepository.findById(id).orElse(null)

    @GetMapping("/buyer/{buyerId}")
    fun getByBuyer(@PathVariable buyerId: Int): List<Order> = orderRepository.findByBuyerId(buyerId)

    @PostMapping
    fun create(@RequestBody order: Order): Order = orderRepository.save(order)
}
