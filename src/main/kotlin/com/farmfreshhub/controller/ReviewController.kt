package com.farmfreshhub.controller

import com.farmfreshhub.entity.Review
import com.farmfreshhub.repository.ReviewRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products/{productId}/reviews")
class ReviewController(private val reviewRepository: ReviewRepository) {

    @GetMapping
    fun getReviews(@PathVariable productId: Int): List<Review> =
        reviewRepository.findByProductId(productId)

    @PostMapping
    fun addReview(@PathVariable productId: Int, @RequestBody review: Review): Review =
        reviewRepository.save(review.copy(productId = productId))
}
