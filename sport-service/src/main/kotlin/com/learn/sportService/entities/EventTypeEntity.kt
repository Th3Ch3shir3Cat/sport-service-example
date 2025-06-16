package com.learn.sportService.entities

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "event_types")
class EventTypeEntity(
    var name: String? = null
) : SharedKey<Long>()