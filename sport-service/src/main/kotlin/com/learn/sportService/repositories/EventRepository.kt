package com.learn.sportService.repositories

import com.learn.sportService.entities.EventEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.time.OffsetDateTime
import java.util.Optional

interface EventRepository : JpaRepository<EventEntity, Long> {

    fun findByName(eventName: String): Optional<EventEntity>

    fun findAllByStartTimeAfterAndEndTimeBefore(startTime: OffsetDateTime, endTime: OffsetDateTime): List<EventEntity>
}