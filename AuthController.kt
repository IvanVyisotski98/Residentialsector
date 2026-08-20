package by.mvd.residential.controller

import by.mvd.residential.dto.LoginRequest
import by.mvd.residential.dto.LoginResponse
import by.mvd.residential.repository.UserRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = ["*"])
class AuthController(private val userRepository: UserRepository) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): ResponseEntity<Any> {
        val user = userRepository.findByLogin(request.login)

        return if (user != null && user.password == request.password) {
            ResponseEntity.ok(
                LoginResponse(
                    token = "jwt_token_${user.id}",
                    fullName = user.fullName
                )
            )
        } else {
            ResponseEntity.status(401).body(mapOf("error" to "Неверный логин или пароль"))
        }
    }
}