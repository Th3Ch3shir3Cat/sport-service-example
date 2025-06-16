package com.learn.sportService.feign

import com.learn.sportService.dao.BaseResponse
import com.learn.sportService.dao.TeamScheduleBody
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "sport-team-management", path = "/api/v1")
interface TeamManagementFeignService {

    @PostMapping("/createSchedule")
    fun createSchedule(@RequestBody teamScheduleBody: TeamScheduleBody) : ResponseEntity<BaseResponse>
}