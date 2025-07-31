package com.farmfreshhub.entity


import jakarta.persistence.*

@Entity
@Table(name = "categories")
data class Category(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val categoryId: Int = 0,
    val name: String = ""
)
