package com.farmfreshhub.controller

import com.farmfreshhub.entity.Product
import com.farmfreshhub.repository.ProductRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(private val productRepository: ProductRepository) {

    @GetMapping
    fun getAll(): List<Product> = productRepository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): Product? = productRepository.findById(id).orElse(null)

    @GetMapping("/category/{categoryId}")
    fun getByCategory(@PathVariable categoryId: Int): List<Product> =
        productRepository.findByCategoryId(categoryId)

    @GetMapping("/farmer/{farmerId}")
    fun getByFarmer(@PathVariable farmerId: Int): List<Product> =
        productRepository.findByFarmerId(farmerId)

    @PostMapping("create")
    fun create(@RequestBody product: Product): Product = productRepository.save(product)
}
