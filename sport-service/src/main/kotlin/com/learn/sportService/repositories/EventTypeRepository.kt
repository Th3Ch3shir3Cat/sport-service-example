package com.learn.sportService.repositories

import com.learn.sportService.entities.EventTypeEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface EventTypeRepository : JpaRepository<EventTypeEntity, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM event_types et WHERE lower(et.name) = :name")
    fun findByName(name: String): Optional<EventTypeEntity>
}