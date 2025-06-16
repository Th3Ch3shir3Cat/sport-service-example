package org.learn.gerbert.sportnotification

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class SportNotificationApplication

fun main(args: Array<String>) {
    runApplication<SportNotificationApplication>(*args)
}
