package br.com.dougg.growdiary.controller

import br.com.dougg.growdiary.entity.DiaryPage
import br.com.dougg.growdiary.model.ActionEnum
import br.com.dougg.growdiary.model.DayInfo
import br.com.dougg.growdiary.service.PageDiaryService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/diary")
class DiaryController(private val pageDiaryService: PageDiaryService) {

    @PostMapping("/new-page")
    fun createNewPage(@RequestBody page: DiaryPage): ResponseEntity<DiaryPage> {

        return ResponseEntity.status(HttpStatus.OK).body(pageDiaryService.savePage(page))
    }

    @GetMapping("/page/to-date/{date}")
    fun getPagesPerDate(@PathVariable date: String): ResponseEntity<DiaryPage> {
        val dateConverted: LocalDate = LocalDate.parse(date)
        return ResponseEntity.status(HttpStatus.OK).body(pageDiaryService.getPagesToDate(dateConverted))
    }

    @GetMapping("/list/all-pages")
    fun getAllPagesFromDataBase() =
            ResponseEntity.status(HttpStatus.OK).body(pageDiaryService.getAllPages())
}