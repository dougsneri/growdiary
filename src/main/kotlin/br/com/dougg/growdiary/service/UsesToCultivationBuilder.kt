package br.com.dougg.growdiary.service

import br.com.dougg.growdiary.model.DayInfo
import br.com.dougg.growdiary.model.MoonDay
import br.com.dougg.growdiary.model.MoonPhase.*
import br.com.dougg.growdiary.model.Use
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

    fun build(): DayInfo {
        return when (currentMoonDay.lunarPhase) {
            CHEIA -> fullMoonFlow()
            NOVA -> newMoonFlow()
            MINGUANTE -> waningCrescentMoonFlow()
            CRESCENTE -> waxingCrescentMoonFlow()
        }
    }

    private fun waxingCrescentMoonFlow(): DayInfo {
        val days = ChronoUnit.DAYS.between(currentMoonDay.date, dateToConsult) + 1 //Soma + 1 para contar o dia da lua
        if(days < 5)
            return DayInfo(dateToConsult, listOf(Use.TRANSPLANTE))

        return DayInfo(dateToConsult, listOf(Use.GERMINACAO))
    }

    private fun waningCrescentMoonFlow(): DayInfo {
        val days = ChronoUnit.DAYS.between(currentMoonDay.date, dateToConsult) + 1 //Soma + 1 para contar o dia da lua
        return when{
            days < 2 -> DayInfo(dateToConsult, listOf(Use.ADUBO, Use.CLONES))
            days < 5 -> DayInfo(dateToConsult, listOf(Use.ADUBO, Use.CLONES, Use.PODA))
            else -> DayInfo(dateToConsult, listOf(Use.ADUBO, Use.CLONES, Use.PODA, Use.CONTROLE_PRAGAS))
        }
    }

    private fun newMoonFlow() = DayInfo(dateToConsult, listOf(Use.CONTROLE_PRAGAS, Use.PODA))

    private fun fullMoonFlow() = DayInfo(dateToConsult, listOf(Use.GERMINACAO, Use.ADUBO, Use.TRANSPLANTE))


}