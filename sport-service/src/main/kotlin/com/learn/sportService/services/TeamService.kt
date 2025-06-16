package com.learn.sportService.services

import com.learn.openapi.sport.models.Team
import com.learn.openapi.sport.models.TeamBody
import com.learn.sportService.mappers.TeamMapper
import com.learn.sportService.repositories.TeamRepository
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class TeamService (
    private val teamRepository: TeamRepository,
    private val teamMapper : TeamMapper
) {

    fun saveTeam(team: TeamBody) : Team {
        val teamEntity = teamRepository.findByName(team.name.lowercase())
        var resultTeam : Team? = null
        teamEntity.ifPresentOrElse({
            it.description = team.description
            it.updatedAt = OffsetDateTime.now()
            resultTeam = teamMapper.mapTeam(teamRepository.save(it))
        }, {
            val newTeam = teamMapper.mapTeam(team)
            newTeam.createdAt = OffsetDateTime.now()
            newTeam.updatedAt = OffsetDateTime.now()
            resultTeam = teamMapper.mapTeam(teamRepository.save(newTeam))
        })
        return requireNotNull(resultTeam)
    }

    fun getAllTeams(): List<Team> {
        return teamRepository.findAll().map { teamMapper.mapTeam(it) }
    }
}