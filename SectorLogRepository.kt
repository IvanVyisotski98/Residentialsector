package by.mvd.residential.repository

import by.mvd.residential.model.entity.SectorLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SectorLogRepository : JpaRepository<SectorLog, Long> {
    fun findByUserId(userId: Long): List<SectorLog>
    fun findByFullNameContainingIgnoreCase(name: String): List<SectorLog>
}