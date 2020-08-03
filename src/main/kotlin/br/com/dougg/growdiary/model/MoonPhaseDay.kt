package br.com.dougg.growdiary.model

import java.time.LocalDate

data class MoonPhaseDay(
        val moonPhase: MoonPhaseEnum,

        val date: LocalDate
)