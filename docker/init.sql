-- User Management Service Schema
CREATE TABLE users
(
    user_id       UUID PRIMARY KEY,
    username      VARCHAR(255) UNIQUE NOT NULL,
    email         VARCHAR(255),
    created_at    TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);