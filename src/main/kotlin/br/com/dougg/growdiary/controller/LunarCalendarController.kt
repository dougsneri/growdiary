package br.com.dougg.growdiary.controller

import br.com.dougg.growdiary.model.DayInfo
import br.com.dougg.growdiary.model.MoonDay
import br.com.dougg.growdiary.repository.MoonDayRepository
import br.com.dougg.growdiary.service.LunarDayService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/calendar")
class LunarCalendarController(private val lunarDayService: LunarDayService, private val moonDayRepository: MoonDayRepository) {

    @GetMapping("/uses")
    fun getUses(@RequestBody date: LocalDate): ResponseEntity<DayInfo> {

        return ResponseEntity.status(200).body(lunarDayService.getUsesToDate(date))
    }

    @PostMapping("/create/moon-phase-dates")
    fun saveMoonPhaseDates(@RequestBody dates: List<MoonDay>): List<MoonDay> {
        return lunarDayService.createMoonPhaseDates(dates)
    }

    @GetMapping("/all")
    fun getDays(): List<MoonDay> {
        return moonDayRepository.findAll()
    }

}