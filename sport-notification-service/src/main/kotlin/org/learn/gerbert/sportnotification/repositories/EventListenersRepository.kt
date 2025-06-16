package org.learn.gerbert.sportnotification.repositories

import org.learn.gerbert.sportnotification.entities.EventListenerEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EventListenersRepository : JpaRepository<EventListenerEntity, Long> {
    fun findAllByKey(key: String): List<EventListenerEntity>
}