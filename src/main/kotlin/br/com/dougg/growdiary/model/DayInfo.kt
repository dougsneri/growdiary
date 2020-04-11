package br.com.dougg.growdiary.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class DayInfo(
        val date: LocalDate,
        @JsonProperty("make_use")
        val makeUse: List<Use>
)