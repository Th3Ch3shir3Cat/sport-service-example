package org.learn.gerbert.sportteammanagment.services

import com.learn.openapi.sport.models.Schedule
import com.learn.openapi.sport.models.ScheduleBody
import org.learn.gerbert.sportteammanagment.mappers.TeamScheduleMapper
import org.learn.gerbert.sportteammanagment.repositories.TeamScheduleRepository
import org.springframework.stereotype.Service

@Service
class TeamScheduleService(
    val teamScheduleRepository: TeamScheduleRepository,
    val teamScheduleMapper: TeamScheduleMapper
){

    fun save(teamSchedule: ScheduleBody) : Schedule {
        return teamScheduleMapper.mapTeamSchedule(teamScheduleRepository.save(teamScheduleMapper.mapTeamSchedule(teamSchedule)))
    }
}