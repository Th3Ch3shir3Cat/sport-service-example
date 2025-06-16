package com.learn.sportService.mappers

import com.learn.openapi.sport.models.EventType
import com.learn.openapi.sport.models.EventTypeBody
import com.learn.sportService.entities.EventTypeEntity
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import java.time.OffsetDateTime

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, imports = [OffsetDateTime::class])
interface EventTypeMapper {

    fun mapEventType(eventType: EventTypeEntity) : EventType

    @Mapping(target = "createdAt", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(OffsetDateTime.now())")
    fun mapEventType(eventType: EventTypeBody) : EventTypeEntity
}