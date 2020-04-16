package br.com.dougg.growdiary.controller

import br.com.dougg.growdiary.entity.EclipseDay
import br.com.dougg.growdiary.entity.MoonDay
import br.com.dougg.growdiary.service.EclipseDatesService
import br.com.dougg.growdiary.service.MoonPhaseDatesService
import br.com.dougg.growdiary.service.UsesToCultivationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import java.time.LocalDate

@RestController
@RequestMapping("/calendar")
class LunarCalendarController(private val usesToCultivationService: UsesToCultivationService,
                              private val moonPhaseDatesService: MoonPhaseDatesService,
                              private val eclipseDatesService: EclipseDatesService) {

    @GetMapping("/uses/to-date/{date}")
    fun getUsesToCultivationPerDate(@PathVariable date: LocalDate) =
            ResponseEntity.status(HttpStatus.OK).body(usesToCultivationService.getUsesToDate(date))

    @PostMapping("/create/moon-phase-dates")
    fun createMoonPhaseDates(@RequestBody dates: List<MoonDay>) =
            ResponseEntity.status(HttpStatus.OK).body(moonPhaseDatesService.createMoonPhaseDates(dates))

    @GetMapping("/list/moon-phase-dates")
    fun getMoonPhaseDatesFromDataBase() =
            ResponseEntity.status(HttpStatus.OK).body(moonPhaseDatesService.getAllMoonDates())

    @PostMapping("/create/eclipse-dates")
    fun createEclipseDates(@RequestBody eclipseDates: List<EclipseDay>) =
            ResponseEntity.status(HttpStatus.OK).body(eclipseDatesService.createEclipseDates(eclipseDates))

    @GetMapping("/list/eclipse-dates")
    fun getEclipseDatesFromDataBase() =
            ResponseEntity.status(HttpStatus.OK).body(eclipseDatesService.getAllEclipseDates())

}