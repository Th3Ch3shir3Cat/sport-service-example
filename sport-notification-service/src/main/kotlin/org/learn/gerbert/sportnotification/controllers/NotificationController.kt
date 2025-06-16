package org.learn.gerbert.sportnotification.controllers

import com.learn.openapi.sport.apis.ListenerApi
import com.learn.openapi.sport.apis.ListenersApi
import com.learn.openapi.sport.apis.NotificationApi
import com.learn.openapi.sport.models.BaseResponse
import com.learn.openapi.sport.models.InfoForSend
import com.learn.openapi.sport.models.Listener
import com.learn.openapi.sport.models.ListenerBody
import org.learn.gerbert.sportnotification.services.NotificationService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class NotificationController(
    val notificationService: NotificationService
) :NotificationApi, ListenerApi, ListenersApi {

    val logger: Logger = LoggerFactory.getLogger(NotificationController::class.java)

    override fun addListener(listenerBody: ListenerBody): ResponseEntity<Listener> {
        logger.info("Adding listener $listenerBody")
        return ResponseEntity(notificationService.save(listenerBody), HttpStatus.OK)

    }

    override fun getAllListeners(): ResponseEntity<List<Listener>> {
        logger.info("Getting all listeners")
        return ResponseEntity(notificationService.getAllListeners(), HttpStatus.OK)
    }

    override fun sendNotification(infoForSend: InfoForSend): ResponseEntity<BaseResponse> {
        logger.info("sendNotification for ${infoForSend.key}")
        notificationService.sendToListeners(infoForSend.key)
        return ResponseEntity(BaseResponse("notifications about ${infoForSend.key} send"), HttpStatus.OK)
    }
}