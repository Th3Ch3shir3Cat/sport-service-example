package com.learn.sportService.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@Entity
@Table(name = "teams")
class TeamEntity(

    var name: String? = null,

    var description: String? = null,

    @ManyToMany
    @JoinTable(name = "events_teams",
        joinColumns = [JoinColumn(name = "event_id", referencedColumnName = "id")],
        inverseJoinColumns = [JoinColumn(name = "team_id", referencedColumnName = "id")]
    )
    @JsonIgnoreProperties("events")
    var events: MutableList<EventEntity>? = null
) : SharedKey<Long>()