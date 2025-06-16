package org.learn.gerbert.sportnotification.entities

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "event_listeners")
class EventListenerEntity (
    var key: String? = null,
    var email: String? = null
)  : SharedKey<Long>()