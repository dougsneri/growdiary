package br.com.dougg.growdiary.service

import br.com.dougg.growdiary.model.MoonDay
import br.com.dougg.growdiary.repository.MoonDayRepository
import org.springframework.stereotype.Service

@Service
class MoonPhaseDatesService(private val moonDayRepository: MoonDayRepository) {

    fun createMoonPhaseDates(datesToSave: List<MoonDay>): List<MoonDay> {
        val datesMoonPhaseCreated = ArrayList<MoonDay>()
        datesToSave.stream().forEach { dateToSave -> datesMoonPhaseCreated.add(moonDayRepository.save(dateToSave)) }

        return datesMoonPhaseCreated
    }

    fun getAllMoonDates(): List<MoonDay> {
        val moonDaysToReturn = ArrayList<MoonDay>()
        val moonDaysFromDataBase = moonDayRepository.findAll()

        moonDaysFromDataBase.forEach { moonDay -> moonDaysToReturn.add(moonDay) }
        moonDaysToReturn.sortByDescending { moonDay -> moonDay.date }

        return moonDaysToReturn
    }
}