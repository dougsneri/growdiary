package br.com.dougg.growdiary.model

import java.time.LocalDate

data class MoonPhaseYear(
        val moonPhase: MoonPhase,
        val dates: List<LocalDate>
)