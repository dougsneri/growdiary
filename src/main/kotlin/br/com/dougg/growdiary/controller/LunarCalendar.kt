package br.com.dougg.growdiary.controller

import br.com.dougg.growdiary.model.DayInfo
import br.com.dougg.growdiary.model.Use
import br.com.dougg.growdiary.service.LunarDayService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@RestController
@RequestMapping("/calendar")
class LunarCalendar(private val lunarDayService: LunarDayService) {

    @GetMapping
    fun getUses(date: LocalDate): ResponseEntity<DayInfo> {

        return ResponseEntity.status(200).body(lunarDayService.getUsesToDate(date))
    }
}