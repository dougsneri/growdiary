package br.com.dougg.growdiary.service

import br.com.dougg.growdiary.model.DayInfo
import br.com.dougg.growdiary.model.Use
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class LunarDayService {
    fun getUsesToDate(date: LocalDate): DayInfo {




        return DayInfo(LocalDate.now(), listOf(Use.ADUBO, Use.PODA))
    }
}