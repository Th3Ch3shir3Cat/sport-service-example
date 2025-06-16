package org.learn.gerbert.sportteammanagment.controllers

import com.learn.openapi.sport.apis.ScheduleApi
import com.learn.openapi.sport.models.BaseResponse
import com.learn.openapi.sport.models.Schedule
import com.learn.openapi.sport.models.ScheduleBody
import org.learn.gerbert.sportteammanagment.services.TeamScheduleService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TeamScheduleController (
    val teamScheduleService: TeamScheduleService,
) : ScheduleApi{

    val logger: Logger = LoggerFactory.getLogger(TeamScheduleController::class.java)

    override fun createSchedule(scheduleBody: ScheduleBody): ResponseEntity<BaseResponse> {
        logger.info("Create new schedule for team with id ${scheduleBody.teamId}")
        teamScheduleService.save(scheduleBody)
        return ResponseEntity(BaseResponse("schedule for ${scheduleBody.teamId} created"), HttpStatus.OK)
    }
}