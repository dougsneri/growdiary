package br.com.dougg.growdiary.repository

import br.com.dougg.growdiary.model.MoonDay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MoonDayRepository: JpaRepository<MoonDay, Int>
