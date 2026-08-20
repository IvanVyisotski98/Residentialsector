package by.mvd.residential.controller

import by.mvd.residential.dto.DashboardStats
import by.mvd.residential.repository.SectorLogRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = ["*"])
class DashboardController(private val repository: SectorLogRepository) {

    @GetMapping
    fun getStats(): DashboardStats {
        val logs = repository.findAll()

        val totalResidents = logs.size
        val totalApartments = logs.map { "${it.street}|${it.house}" }.distinct().size
        val totalPritons = logs.count { it.isWatchListed }
        val percent = if (totalResidents > 0) (totalResidents * 100 / 200).coerceAtMost(100) else 0

        return DashboardStats(
            totalResidents = totalResidents,
            totalApartments = totalApartments,
            totalPritons = totalPritons,
            percent = percent
        )
    }
}