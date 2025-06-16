package com.learn.sportService.repositories

import com.learn.sportService.entities.SportEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface SportRepository : JpaRepository<SportEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM sports s WHERE lower(s.name) = :name")
    fun findByName(name: String): Optional<SportEntity>
}