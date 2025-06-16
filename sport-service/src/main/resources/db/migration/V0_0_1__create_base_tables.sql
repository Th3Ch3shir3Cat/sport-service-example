CREATE TABLE sports
(
    id          BIGSERIAL    PRIMARY KEY,
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL,
    name        VARCHAR(255) NOT NULL
);

CREATE TABLE teams
(
    id          BIGSERIAL    PRIMARY KEY,
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL,
    name        VARCHAR(255) NOT NULL
);

CREATE TABLE event_types
(
    id          BIGSERIAL    PRIMARY KEY,
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL,
    name        VARCHAR(255) NOT NULL
);

CREATE TABLE events
(
    id              BIGSERIAL    PRIMARY KEY,
    created_at      TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at      TIMESTAMP    NOT NULL,
    name            VARCHAR(255) NOT NULL,
    start_time      TIMESTAMP,
    end_time        TIMESTAMP,
    event_type_id   BIGINT
);

CREATE TABLE events_teams
(
    id              BIGSERIAL    PRIMARY KEY,
    event_id        BIGINT       NOT NULL,
    team_id         BIGINT       NOT NULL
);

ALTER TABLE events
    ADD CONSTRAINT EVENTS_EVENT_TYPE_ID_FK
        FOREIGN KEY (event_type_id) REFERENCES event_types;

ALTER TABLE events_teams
    ADD CONSTRAINT EVENTS_TEAMS_EVENT_ID_FK
        FOREIGN KEY (event_id) REFERENCES events;

ALTER TABLE events_teams
    ADD CONSTRAINT EVENTS_TEAMS_TEAM_ID_FK
        FOREIGN KEY (team_id) REFERENCES teams;