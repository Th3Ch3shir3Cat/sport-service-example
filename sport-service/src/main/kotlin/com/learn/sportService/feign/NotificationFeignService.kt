package com.learn.sportService.feign

import com.learn.sportService.dao.BaseResponse
import com.learn.sportService.dao.InfoForSend
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "sport-notification-service", path = "/api/v1")
interface NotificationFeignService {

    @PostMapping("/sendNotification")
    fun sendNotification(@RequestBody infoForSend : InfoForSend) : ResponseEntity<BaseResponse>
}