package com.learn.sportService.entities

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "sports")
class SportEntity(
    var name: String? = null
) : SharedKey<Long>()