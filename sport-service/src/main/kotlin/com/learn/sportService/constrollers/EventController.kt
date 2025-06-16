package com.learn.sportService.constrollers

import com.learn.openapi.sport.apis.EventApi
import com.learn.openapi.sport.apis.EventTypeApi
import com.learn.openapi.sport.apis.EventTypesApi
import com.learn.openapi.sport.apis.EventsApi
import com.learn.openapi.sport.models.Event
import com.learn.openapi.sport.models.EventType
import com.learn.openapi.sport.models.EventTypeBody
import com.learn.sportService.services.EventService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController (
    private val eventService: EventService
) : EventTypeApi, EventTypesApi, EventApi, EventsApi {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun createEventType(eventTypeBody: EventTypeBody): ResponseEntity<EventType> {
        logger.info("Creating new EventType with body: $eventTypeBody")
        return ResponseEntity(eventService.createEventType(eventTypeBody), HttpStatus.OK)
    }

    override fun getAllEventTypes(): ResponseEntity<List<EventType>> {
        logger.info("getAllEventTypes()")
        return ResponseEntity(eventService.getAllEventTypes(), HttpStatus.OK)
    }

    override fun createOrUpdateEvent(event: Event): ResponseEntity<Event> {
        logger.info("Creating new Event: $event")
        return ResponseEntity(eventService.createEvent(event), HttpStatus.OK)
    }

    override fun getAllEvents(): ResponseEntity<List<Event>> {
        logger.info("getAllEvents()")
        return ResponseEntity(eventService.getAllEvents(),HttpStatus.OK)
    }
}