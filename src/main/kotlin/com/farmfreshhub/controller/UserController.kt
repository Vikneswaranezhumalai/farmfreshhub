
package com.farmfreshhub.controller

import com.farmfreshhub.entity.ErrorResponse
import com.farmfreshhub.entity.User
import com.farmfreshhub.entity.UserResponse
import com.farmfreshhub.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userRepository: UserRepository) {

    // 1. Get all users
    @GetMapping
    fun getAllUsers(): List<User> = userRepository.findAll()

    // 2. Get user by ID
    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Int): ResponseEntity<User> =
        userRepository.findById(id).map { ResponseEntity.ok(it) }
            .orElse(ResponseEntity.notFound().build())

    // 3. Register new user
    @PostMapping("/signup")
    fun registerUser(@RequestBody user: User): ResponseEntity<Any> {
        val existing = userRepository.findByEmail(user.email)
        return if (existing == null) {
            val savedUser = userRepository.save(user)
            ResponseEntity.ok(
                UserResponse(
                    success = true,
                    message = "Registration successful",
                    user = savedUser
                )
            )
        } else {
            ResponseEntity.badRequest().body(
                ErrorResponse(
                    message = "Email already exists"
                )
            )
        }
    }

    // 4. Update user
    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Int, @RequestBody updated: User): ResponseEntity<User> {
        return userRepository.findById(id).map { existing ->
            val userToSave = existing.copy(
                name = updated.name,
                email = updated.email,
                passwordHash = updated.passwordHash,
                userType = updated.userType,
                phone = updated.phone,
                address = updated.address
            )
            ResponseEntity.ok(userRepository.save(userToSave))
        }.orElse(ResponseEntity.notFound().build())
    }

    // 5. Delete user
    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Int): ResponseEntity<Void> {
        return if (userRepository.existsById(id)) {
            userRepository.deleteById(id)
            ResponseEntity.ok().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // 6. Login (basic example, **not production secure**)
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<Any> {
        val user = userRepository.findByEmail(loginRequest.email)
        return if (user != null && user.passwordHash == loginRequest.passwordHash) {
            ResponseEntity.ok(
                UserResponse(
                    success = true,
                    message = "Login successful",
                    user = user,
                )
            )
        } else {
            ResponseEntity.status(401).body(
                ErrorResponse(
                    message = "Invalid credentials"
                )
            )
        }
    }

    // Data class for login request body
    data class LoginRequest(val email: String, val passwordHash: String)
}

