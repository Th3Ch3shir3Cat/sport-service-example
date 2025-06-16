package com.learn.sportService.entities

import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.OffsetDateTime

@MappedSuperclass
abstract class SharedKey<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: T? = null

    @CreatedDate
    @Column(updatable = false, nullable = false)
    lateinit var createdAt: OffsetDateTime

    @LastModifiedDate
    @Column(nullable = false)
    lateinit var updatedAt: OffsetDateTime
}