package org.learn.gerbert.sportnotification.mappers

import com.learn.openapi.sport.models.Listener
import com.learn.openapi.sport.models.ListenerBody
import org.learn.gerbert.sportnotification.entities.EventListenerEntity
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import java.time.OffsetDateTime

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, imports = [OffsetDateTime::class])
interface EventListenerMapper {

    @Mapping(target = "createdAt", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(OffsetDateTime.now())")
    fun mapEventListener(listener: ListenerBody) : EventListenerEntity

    fun mapEventListener(listener: EventListenerEntity) : Listener
}