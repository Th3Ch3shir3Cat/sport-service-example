package com.learn.sportService.mappers


import com.learn.openapi.sport.models.Sport
import com.learn.openapi.sport.models.SportBody
import com.learn.sportService.entities.SportEntity
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import java.time.OffsetDateTime

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, imports = [OffsetDateTime::class])
interface SportMapper {

    fun mapSport(sport: SportEntity) : Sport

    @Mapping(target = "createdAt", expression = "java(OffsetDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(OffsetDateTime.now())")
    fun mapSport(sport: SportBody) : SportEntity
}