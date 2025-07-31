package com.farmfreshhub.controller

import com.farmfreshhub.entity.Category
import com.farmfreshhub.repository.CategoryRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(private val categoryRepository: CategoryRepository) {
    @GetMapping
    fun getAll(): List<Category> = categoryRepository.findAll()

    @PostMapping
    fun create(@RequestBody category: Category): Category = categoryRepository.save(category)
}
