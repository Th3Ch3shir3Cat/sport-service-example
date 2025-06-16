package com.learn.sportService.repositories

import com.learn.sportService.entities.TeamEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface TeamRepository : JpaRepository<TeamEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM teams t WHERE lower(t.name) = :name")
    fun findByName(name: String): Optional<TeamEntity>

}