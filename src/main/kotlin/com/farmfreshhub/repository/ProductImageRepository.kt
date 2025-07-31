package com.farmfreshhub.repository


import com.farmfreshhub.entity.ProductImage
import org.springframework.data.jpa.repository.JpaRepository

interface ProductImageRepository : JpaRepository<ProductImage, Int> {
    fun findByProductId(productId: Int): List<ProductImage>
}
