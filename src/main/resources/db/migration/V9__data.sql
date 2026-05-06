-- =========================
-- COUNTRIES (10 records)
-- =========================
INSERT INTO countries (name, continent)
VALUES
    ('Macedonia', 'Europe'),
    ('United States', 'North America'),
    ('France', 'Europe'),
    ('Japan', 'Asia'),
    ('Chile', 'South America'),
    ('Germany', 'Europe'),
    ('Italy', 'Europe'),
    ('Brazil', 'South America'),
    ('Canada', 'North America'),
    ('Australia', 'Oceania');


-- =========================
-- HOSTS (10 records)
-- =========================
INSERT INTO hosts (name, surname, country_id)
VALUES
    ('Nikola', 'Nikolov', (SELECT id FROM countries WHERE name='Macedonia')),
    ('Kiril', 'Kirilov', (SELECT id FROM countries WHERE name='United States')),
    ('Ana', 'Anova', (SELECT id FROM countries WHERE name='France')),
    ('Zan', 'Zanov', (SELECT id FROM countries WHERE name='Japan')),
    ('Petar', 'Petrov', (SELECT id FROM countries WHERE name='Germany')),
    ('Elena', 'Ilieva', (SELECT id FROM countries WHERE name='Italy')),
    ('Marko', 'Markov', (SELECT id FROM countries WHERE name='Chile')),
    ('Ivana', 'Ivanova', (SELECT id FROM countries WHERE name='Brazil')),
    ('Stefan', 'Stefanov', (SELECT id FROM countries WHERE name='Canada')),
    ('Maja', 'Majova', (SELECT id FROM countries WHERE name='Australia'));


-- =========================
-- ACCOMMODATIONS (10 records)
-- =========================
INSERT INTO accommodations (name, category, host_id, num_rooms, accommodation_state)
VALUES
    ('Villa Lake', 'HOUSE',
     (SELECT id FROM hosts WHERE name='Nikola'), 5, 1),

    ('City Apartment', 'APARTMENT',
     (SELECT id FROM hosts WHERE name='Kiril'), 2, 0),

    ('Tokyo Hotel', 'HOTEL',
     (SELECT id FROM hosts WHERE name='Zan'), 20, 1),

    ('Paris Stay', 'HOTEL',
     (SELECT id FROM hosts WHERE name='Ana'), 15, 1),

    ('Berlin House', 'HOUSE',
     (SELECT id FROM hosts WHERE name='Petar'), 4, 0),

    ('Rome Flat', 'APARTMENT',
     (SELECT id FROM hosts WHERE name='Elena'), 3, 1),

    ('Santiago Lodge', 'HOUSE',
     (SELECT id FROM hosts WHERE name='Marko'), 6, 1),

    ('Rio Hostel', 'APARTMENT',
     (SELECT id FROM hosts WHERE name='Ivana'), 8, 0),

    ('Toronto Inn', 'HOTEL',
     (SELECT id FROM hosts WHERE name='Stefan'), 12, 1),

    ('Sydney Villa', 'HOUSE',
     (SELECT id FROM hosts WHERE name='Maja'), 7, 1);