package com.farmfreshhub.repository

import com.farmfreshhub.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Int> {
    fun findByCategoryId(categoryId: Int): List<Product>
    fun findByFarmerId(farmerId: Int): List<Product>
}
