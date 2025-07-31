package com.farmfreshhub.repository

import com.farmfreshhub.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Int>
