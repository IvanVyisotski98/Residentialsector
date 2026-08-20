package by.mvd.residential.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(unique = true, nullable = false)
    val login: String = "",

    @Column(nullable = false)
    val password: String = "",

    val fullName: String = "",
    val districtId: Long = 0
)