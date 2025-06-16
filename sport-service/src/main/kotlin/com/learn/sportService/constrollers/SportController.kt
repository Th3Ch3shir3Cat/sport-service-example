package com.learn.sportService.constrollers

import com.learn.openapi.sport.apis.SportApi
import com.learn.openapi.sport.apis.SportsApi
import com.learn.openapi.sport.models.Sport
import com.learn.openapi.sport.models.SportBody
import com.learn.sportService.services.SportService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class SportController (
    private val sportService: SportService
) : SportApi, SportsApi{

    val logger: Logger = LoggerFactory.getLogger(SportController::class.java)

    override fun createSport(sportBody: SportBody): ResponseEntity<Sport> {
        logger.info("Creating sport with body: $sportBody")
        return ResponseEntity(sportService.createSport(sportBody), HttpStatus.OK)
    }

    override fun getAllSports(): ResponseEntity<List<Sport>> {
        logger.info("Call /getAllSports")
        return ResponseEntity(sportService.getAllSports(), HttpStatus.OK)
    }
}