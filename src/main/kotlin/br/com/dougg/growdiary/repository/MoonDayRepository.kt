package br.com.dougg.growdiary.repository

import br.com.dougg.growdiary.entity.MoonDay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MoonDayRepository : JpaRepository<MoonDay, Int>
