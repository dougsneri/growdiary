package br.com.dougg.growdiary.repository

import br.com.dougg.growdiary.entity.EclipseDay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EclipseDayRepository : JpaRepository<EclipseDay, Int>