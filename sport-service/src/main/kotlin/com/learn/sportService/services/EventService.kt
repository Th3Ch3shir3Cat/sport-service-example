package com.learn.sportService.services

import com.learn.openapi.sport.models.Event
import com.learn.openapi.sport.models.EventType
import com.learn.openapi.sport.models.EventTypeBody
import com.learn.openapi.sport.models.Team
import com.learn.sportService.dao.InfoForSend
import com.learn.sportService.dao.TeamScheduleBody
import com.learn.sportService.entities.EventEntity
import com.learn.sportService.entities.TeamEntity
import com.learn.sportService.feign.NotificationFeignService
import com.learn.sportService.feign.TeamManagementFeignService
import com.learn.sportService.mappers.EventMapper
import com.learn.sportService.mappers.EventTypeMapper
import com.learn.sportService.repositories.EventRepository
import com.learn.sportService.repositories.EventTypeRepository
import com.learn.sportService.repositories.TeamRepository
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.logging.Logger

@Service
class EventService (
    private val eventTypeRepository: EventTypeRepository,
    private val eventRepository: EventRepository,
    private val eventTypeMapper : EventTypeMapper,
    private val eventMapper: EventMapper,
    private val teamRepository: TeamRepository,
    private val notificationFeignService: NotificationFeignService,
    private val teamManagementFeignService: TeamManagementFeignService
)
{

    val logger: Logger = Logger.getLogger(this.javaClass.name)

    fun getAllEventTypes(): List<EventType> {
        return eventTypeRepository.findAll().map { eventTypeMapper.mapEventType(it) }
    }

    fun createEventType(eventTypeBody: EventTypeBody): EventType {
        if(!eventTypeRepository.findByName(eventTypeBody.name.lowercase()).isPresent) {
            return eventTypeMapper.mapEventType(eventTypeRepository.save(eventTypeMapper.mapEventType(eventTypeBody)))
        }
        throw IllegalArgumentException("Event type with name ${eventTypeBody.name.lowercase()} already exists.")
    }


    fun createEvent(event: Event): Event {
        eventRepository.findByName(event.name).ifPresentOrElse({
            it.updatedAt = OffsetDateTime.now()
            it.startTime = event.startTime
            it.endTime = event.endTime
            if(event.teams.isNotEmpty()) {
                findAndSetTeams(event.teams, it)
            }
            findAndSetEventType(event.eventTypeName, it)
            eventRepository.save(it)
            createScheduleForTeams(it)
        },{
            val newEvent = EventEntity()
            newEvent.createdAt = OffsetDateTime.now()
            newEvent.updatedAt = OffsetDateTime.now()
            newEvent.startTime = event.startTime
            newEvent.endTime = event.endTime
            newEvent.name = event.name
            findAndSetEventType(event.eventTypeName, newEvent)
            if(event.teams.isNotEmpty()) {
                findAndSetTeams(event.teams, newEvent)
            }
            eventRepository.save(newEvent)
            createScheduleForTeams(newEvent)
        })
        notificationFeignService.sendNotification(InfoForSend( event.eventTypeName))
        return event
    }

    fun findAndSetTeams(teamsFromBody: List<Team>, event: EventEntity) {
        val teams = ArrayList<TeamEntity>()
        for (team in teamsFromBody) {
            teamRepository.findByName(team.name.lowercase()).ifPresentOrElse({findTeam ->
                teams.add(findTeam)
            },{
                throw IllegalArgumentException("Team with name ${team.name} not found.")
            })
        }
        event.teams = ArrayList(teams)
    }

    fun findAndSetEventType(eventTypeName: String, event: EventEntity) {
        eventTypeRepository.findByName(eventTypeName).ifPresentOrElse({
            event.eventType = it
        }, {
            logger.warning("Event type with name $eventTypeName not found.")
        })
    }

    fun getAllEvents() : List<Event> {
        return eventRepository.findAll().map { eventMapper.mapEvent(it) }
    }

    fun createScheduleForTeams(event: EventEntity) {
        for(team in event.teams!!) {
            teamManagementFeignService.createSchedule(TeamScheduleBody(team.id, event.id, event.startTime, event.endTime))
        }
    }
}