package com.learn.sportService.mappers

import com.learn.openapi.sport.models.Team
import com.learn.openapi.sport.models.TeamBody
import com.learn.sportService.entities.TeamEntity
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import java.time.OffsetDateTime

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, imports = [OffsetDateTime::class])
interface TeamMapper {

    fun mapTeam(team: TeamEntity) : Team


    fun mapTeam(team: TeamBody) : TeamEntity
}