package by.mvd.residential.config

import by.mvd.residential.model.entity.User
import by.mvd.residential.repository.UserRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataInitializer {

    @Bean
    fun init(userRepository: UserRepository): CommandLineRunner {
        return CommandLineRunner {
            if (userRepository.findByLogin("admin") == null) {
                val admin = User(
                    login = "admin",
                    password = "admin",
                    fullName = "Иванов И.И.",
                    districtId = 1
                )
                userRepository.save(admin)
                println("✅ Тестовый пользователь 'admin' создан")
            } else {
                println("ℹ️ Пользователь 'admin' уже существует")
            }
        }
    }
}