package br.com.dougg.growdiary.model

import java.time.LocalDate

data class MoonPhaseDay(
        val moonPhase: MoonPhase,

        val date: LocalDate
)