package com.learn.sportService.dao

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.OffsetDateTime

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class TeamScheduleBody (
    @JsonProperty("teamId")
    var teamId: Long?,
    @JsonProperty("eventId")
    var eventId: Long?,
    @JsonProperty("startDate")
    val startDate: OffsetDateTime?,
    @JsonProperty("endDate")
    val endDate: OffsetDateTime?
)