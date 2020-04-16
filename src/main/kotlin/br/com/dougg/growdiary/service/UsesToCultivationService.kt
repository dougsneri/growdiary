package br.com.dougg.growdiary.service

import br.com.dougg.growdiary.model.DayInfo
import br.com.dougg.growdiary.entity.MoonDay
import br.com.dougg.growdiary.repository.MoonDayRepository
import org.springframework.stereotype.Service
import java.time.LocalDate
import kotlin.collections.ArrayList

@Service
class UsesToCultivationService(private val moonDayRepository: MoonDayRepository) {

    fun getUsesToDate(dateToConsult: LocalDate): DayInfo {
        val datesFromDataBase = moonDayRepository.findAll()

        val currentMoonDay = getCurrentMoonDay(dateToConsult, datesFromDataBase)
        val usesToCultivation = UsesToCultivationBuilder()

        return usesToCultivation
                .withCurrentMoonDay(currentMoonDay)
                .withDateToConsult(dateToConsult)
                .build()
    }

    private fun getCurrentMoonDay(dateToConsult: LocalDate, datesFromDataBase: List<MoonDay>): MoonDay {
        val datesFiltered: ArrayList<MoonDay> = datesFromDataBase.filter {
            moonDay -> (moonDay.date == dateToConsult).or(dateToConsult.isAfter(moonDay.date)) }.toCollection(arrayListOf())

        datesFiltered.sortByDescending { moonDay -> moonDay.date }
        return datesFiltered[0]
    }
}