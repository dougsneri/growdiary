package br.com.dougg.growdiary.model

import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "moon_day")
data class MoonDay(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        val id: Int = 0,

        val date: LocalDate = LocalDate.now(),

        val lunarPhase: MoonPhase = MoonPhase.CHEIA
)
