package by.mvd.residential.controller

import by.mvd.residential.model.entity.SectorLog
import by.mvd.residential.repository.SectorLogRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sector-logs")
@CrossOrigin(origins = ["*"])
class SectorLogController(private val repository: SectorLogRepository) {

    @GetMapping
    fun getAll(): List<SectorLog> = repository.findAll()

    @PostMapping
    fun create(@RequestBody log: SectorLog): SectorLog = repository.save(log)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = repository.deleteById(id)

    @GetMapping("/search")
    fun search(@RequestParam name: String): List<SectorLog> =
        repository.findByFullNameContainingIgnoreCase(name)
}