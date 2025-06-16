CREATE TABLE event_listeners
(
    id          BIGSERIAL    PRIMARY KEY,
    created_at  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP    NOT NULL,
    key         VARCHAR(255) NOT NULL,
    email       VARCHAR(1000) NOT NULL
);