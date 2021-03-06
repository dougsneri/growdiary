package br.com.dougg.growdiary.entity

import br.com.dougg.growdiary.model.EclipseTypeEnum
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "eclipse_day")
data class EclipseDay(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        val id: Int = 0,

        val date: LocalDate = LocalDate.now(),

        val type: EclipseTypeEnum = EclipseTypeEnum.LUNAR
)