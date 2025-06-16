package org.learn.gerbert.sportnotification.services

import com.learn.openapi.sport.models.Listener
import com.learn.openapi.sport.models.ListenerBody
import org.learn.gerbert.sportnotification.mappers.EventListenerMapper
import org.learn.gerbert.sportnotification.repositories.EventListenersRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class NotificationService (
    val eventListenersRepository: EventListenersRepository,
    val eventListenerMapper: EventListenerMapper
){
    val logger: Logger = LoggerFactory.getLogger(NotificationService::class.java)

    fun save(eventListener: ListenerBody) : Listener {
        return eventListenerMapper.mapEventListener(eventListenersRepository.save(eventListenerMapper.mapEventListener(eventListener)))
    }

    fun getAllListeners() : List<Listener> {
        return eventListenersRepository.findAll().map { eventListenerMapper.mapEventListener(it) }
    }

    fun sendToListeners(key: String) {
        val listeners = eventListenersRepository.findAllByKey(key)
        logger.info("Send notifications for $listeners")
    }
}