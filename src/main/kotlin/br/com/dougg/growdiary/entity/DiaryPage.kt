package br.com.dougg.growdiary.entity

import br.com.dougg.growdiary.model.ActionEnum
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "diary_page")
data class DiaryPage(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @JsonIgnore
        val id: Int = 0,

        val date: LocalDate = LocalDate.now(),

        val description: String = "No description",

        val action: ActionEnum
)