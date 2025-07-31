package com.farmfreshhub.repository

import com.farmfreshhub.entity.Review
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<Review, Int> {
    fun findByProductId(productId: Int): List<Review>
}
