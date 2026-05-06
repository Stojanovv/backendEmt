CREATE TABLE activity_log (
                              id BIGSERIAL PRIMARY KEY,
                              accommodation_name VARCHAR(255),
                              event_type VARCHAR(100),
                              timestamp TIMESTAMP
);