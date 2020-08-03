package br.com.dougg.growdiary.repository

import br.com.dougg.growdiary.entity.DiaryPage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiaryPageRepository : JpaRepository<DiaryPage, Int>