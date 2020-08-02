package br.com.dougg.growdiary.service

import br.com.dougg.growdiary.model.DayInfo
import br.com.dougg.growdiary.entity.MoonDay
import br.com.dougg.growdiary.model.MoonPhase.*
import br.com.dougg.growdiary.model.Use.*
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class UsesToCultivationBuilder {

    private lateinit var dateToConsult: LocalDate
    private lateinit var currentMoonDay: MoonDay

    fun withDateToConsult(dateToConsult: LocalDate): UsesToCultivationBuilder {
        this.dateToConsult = dateToConsult
        return this
    }

    fun withCurrentMoonDay(currentMoonDay: MoonDay): UsesToCultivationBuilder {
        this.currentMoonDay = currentMoonDay
        return this
    }

    fun build() = when (currentMoonDay.lunarPhase) {
        CHEIA -> fullMoonFlow()
        NOVA -> newMoonFlow()
        MINGUANTE -> waningCrescentMoonFlow()
        CRESCENTE -> waxingCrescentMoonFlow()
        else -> fullMoonFlow()
    }


    private fun waxingCrescentMoonFlow(): DayInfo {
        val days = ChronoUnit.DAYS.between(currentMoonDay.date, dateToConsult) + 1 //Soma + 1 para contar o dia da lua
        if(days < 5)
            return DayInfo(dateToConsult, CRESCENTE, listOf(TRANSPLANTE))

        return DayInfo(dateToConsult, CRESCENTE, listOf(GERMINACAO))
    }

    private fun waningCrescentMoonFlow(): DayInfo {
        val days = ChronoUnit.DAYS.between(currentMoonDay.date, dateToConsult) + 1 //Soma + 1 para contar o dia da lua
        return when{
            days < 2 -> DayInfo(dateToConsult, MINGUANTE, listOf(ADUBO, CLONES))
            days < 5 -> DayInfo(dateToConsult, MINGUANTE, listOf(ADUBO, CLONES, PODA))
            else -> DayInfo(dateToConsult, MINGUANTE, listOf(ADUBO, CLONES, PODA, CONTROLE_PRAGAS))
        }
    }

    private fun newMoonFlow() = DayInfo(dateToConsult, NOVA, listOf(CONTROLE_PRAGAS, PODA))

    private fun fullMoonFlow() = DayInfo(dateToConsult, CHEIA, listOf(GERMINACAO, ADUBO, TRANSPLANTE))


}