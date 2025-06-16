package org.learn.gerbert.sportteammanagment.repositories

import org.learn.gerbert.sportteammanagment.entities.TeamScheduleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TeamScheduleRepository : JpaRepository<TeamScheduleEntity, Long> {
}