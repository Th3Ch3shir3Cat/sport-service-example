package com.learn.sportService.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
@Table(name = "events")
class EventEntity(
    var name: String? = null,

    var startTime: OffsetDateTime? = null,

    var endTime: OffsetDateTime? = null,

    @ManyToOne
    @JoinColumn(name = "event_type_id")
    var eventType: EventTypeEntity? = null,

    @ManyToMany(mappedBy = "events")
    @JsonIgnoreProperties("events")
    var teams: MutableList<TeamEntity>? = null
) : SharedKey<Long>()