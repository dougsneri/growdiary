package br.com.dougg.growdiary.service

import br.com.dougg.growdiary.model.DayInfo
import br.com.dougg.growdiary.model.MoonDay
import br.com.dougg.growdiary.repository.MoonDayRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.collections.ArrayList

@Service
class LunarDayService(private val moonDayRepository: MoonDayRepository) {
    fun getUsesToDate(dateToConsult: LocalDate): DayInfo {

        val dates = moonDayRepository.findAll()
        val datesFiltered: ArrayList<MoonDay> = dates.filter { date -> (date.date == dateToConsult).or(dateToConsult.isAfter(date.date)) }.toCollection(arrayListOf())
        datesFiltered.sortByDescending { a -> a.date }
        val currentMoonDay = datesFiltered[0]

        val usesToCultivation = UsesToCultivationBuilder()

        return usesToCultivation
                .withCurrentMoonDay(currentMoonDay)
                .withDateToConsult(dateToConsult)
                .build()
    }

    fun createMoonPhaseDates(dates: List<MoonDay>): List<MoonDay> {
        val datesMoonPhaseCreated = ArrayList<MoonDay>()
        dates.stream().forEach { date -> datesMoonPhaseCreated.add(moonDayRepository.save(date)) }

        return datesMoonPhaseCreated
    }
}