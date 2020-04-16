package br.com.dougg.growdiary.service

import br.com.dougg.growdiary.entity.EclipseDay
import br.com.dougg.growdiary.repository.EclipseDayRepository
import org.springframework.stereotype.Service

@Service
class EclipseDatesService(private val eclipseDayRepository: EclipseDayRepository) {

    fun createEclipseDates(eclipseDatesToSave: List<EclipseDay>): List<EclipseDay> {
        val eclipseDaysCreated = ArrayList<EclipseDay>()
        eclipseDatesToSave.forEach { dateToSave -> eclipseDaysCreated.add(eclipseDayRepository.save(dateToSave)) }

        return eclipseDaysCreated
    }

    fun getAllEclipseDates(): List<EclipseDay> {
        val eclipseDaysToReturn = ArrayList<EclipseDay>()
        val eclipseDaysFromDataBase = eclipseDayRepository.findAll()

        eclipseDaysFromDataBase.forEach { eclipseDay -> eclipseDaysToReturn.add(eclipseDay) }
        eclipseDaysToReturn.sortByDescending { eclipseDay -> eclipseDay.date }

        return eclipseDaysToReturn
    }

}
