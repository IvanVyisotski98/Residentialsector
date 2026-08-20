package by.mvd.residential.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "sector_logs")
data class SectorLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val region: String = "",
    val city: String = "",
    val street: String = "",
    val house: String = "",
    val date: String = "",
    val fullName: String = "",
    val birthDate: String = "",
    val phone: String = "",
    val workPlace: String = "",
    val hasWeapon: Boolean = false,
    val residentsInfo: String = "",
    val notes: String = "",
    val isWatchListed: Boolean = false,

    @Column(name = "user_id")
    val userId: Long = 0
)