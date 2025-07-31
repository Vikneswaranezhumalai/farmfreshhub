package com.farmfreshhub.controller

import com.farmfreshhub.entity.ProductImage
import com.farmfreshhub.repository.ProductImageRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products/{productId}/images")
class ProductImageController(private val productImageRepository: ProductImageRepository) {

    @GetMapping
    fun getImages(@PathVariable productId: Int): List<ProductImage> =
        productImageRepository.findByProductId(productId)

    @PostMapping
    fun addImage(@PathVariable productId: Int, @RequestBody image: ProductImage): ProductImage =
        productImageRepository.save(image.copy(productId = productId))
}
