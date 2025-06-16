package com.learn.sportService.mappers

import com.learn.openapi.sport.models.Event
import com.learn.openapi.sport.models.Team
import com.learn.sportService.entities.EventEntity
import com.learn.sportService.entities.EventTypeEntity
import com.learn.sportService.entities.TeamEntity
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Named
import java.time.OffsetDateTime

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, imports = [OffsetDateTime::class])
interface EventMapper {

    @Mapping(target = "eventTypeName", source = "eventType", qualifiedByName = ["mapEventType"])
    fun mapEvent(event: EventEntity) : Event

    fun mapEventTeam(team: TeamEntity) : Team

    @Named("mapEventType")
    fun mapEventType(eventType: EventTypeEntity) : String {
        return eventType.name ?: "not found"
    }
}