package br.com.dougg.growdiary.service

import br.com.dougg.growdiary.entity.DiaryPage
import br.com.dougg.growdiary.model.ActionEnum
import br.com.dougg.growdiary.repository.DiaryPageRepository
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class PageDiaryService(private val diaryPageRepository: DiaryPageRepository) {
    fun savePage(page: DiaryPage): DiaryPage {
        return diaryPageRepository.save(page)
    }

    fun getPagesToDate(dateConverted: LocalDate): DiaryPage {
        return DiaryPage(action = ActionEnum.FLUSH)
    }

    fun getAllPages(): List<DiaryPage> {
        return diaryPageRepository.findAll()
    }
}