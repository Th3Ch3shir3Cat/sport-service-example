package org.learn.gerbert.sportteammanagment.mappers

import com.learn.openapi.sport.models.Schedule
import com.learn.openapi.sport.models.ScheduleBody
import org.learn.gerbert.sportteammanagment.entities.TeamScheduleEntity
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import java.time.OffsetDateTime

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, imports = [OffsetDateTime::class])
interface TeamScheduleMapper {

    @Mapping(target = "createdAt", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(OffsetDateTime.now())")
    fun mapTeamSchedule(schedule: ScheduleBody) : TeamScheduleEntity

    fun mapTeamSchedule(teamSchedule: TeamScheduleEntity) : Schedule
}