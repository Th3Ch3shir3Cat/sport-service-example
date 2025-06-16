package org.learn.gerbert.sportteammanagment.entities

import jakarta.persistence.Entity
import jakarta.persistence.Table
import java.time.OffsetDateTime

@Entity
@Table(name = "team_schedule")
class TeamScheduleEntity (
    var teamId: Long,
    var eventId: Long,
    var startDate: OffsetDateTime,
    var endDate: OffsetDateTime
) : SharedKey<Long>()