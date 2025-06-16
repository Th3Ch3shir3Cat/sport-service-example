package com.learn.sportService.constrollers

import com.learn.openapi.sport.apis.TeamApi
import com.learn.openapi.sport.apis.TeamsApi
import com.learn.openapi.sport.models.Team
import com.learn.openapi.sport.models.TeamBody
import com.learn.sportService.services.TeamService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class TeamController(
    private val teamService: TeamService
) : TeamApi, TeamsApi {

    val logger: Logger = LoggerFactory.getLogger(TeamController::class.java)

    override fun createOrUpdateTeam(teamBody: TeamBody): ResponseEntity<Team> {
        logger.info("Creating new team with body $teamBody")
        return ResponseEntity(teamService.saveTeam(teamBody), HttpStatus.OK)
    }

    override fun getAllTeams(): ResponseEntity<List<Team>> {
        logger.info("Getting all teams")
        return ResponseEntity(teamService.getAllTeams(), HttpStatus.OK)
    }
}