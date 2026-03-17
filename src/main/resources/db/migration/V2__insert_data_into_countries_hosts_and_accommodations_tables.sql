insert into countries (name, continent)
values ('Macedonia', 'Europe'),
       ('United States', 'North America'),
       ('Chile', 'South America'),
       ('France', 'Europe'),
       ('Japan', 'Asia');

insert into hosts (created_at, updated_at, name, surname, country_id)
values (now(), now(), 'Nikola', 'Nikolov', (select id from countries where name = 'Macedonia')),
       (now(), now(), 'Kiril', 'Kirilov', (select id from countries where name = 'United States')),
       (now(), now(), 'Zan', 'Zanov', (select id from countries where name = 'Japan')),
       (now(), now(), 'Stojanka', 'Stojanova', (select id from countries where name = 'France')),
       (now(), now(), 'Ana', 'Anova', (select id from countries where name = 'Chile'));



insert into accommodations (created_at, updated_at, name, category, author_id, num_free)
values (now(), now(), 'Vila', 'HOUSE', (select id from authors where name = 'Nikola'), 4),
       (now(), now(), 'Apartment', 'APARTMENT',
        (select id from authors where name = 'Zan' and surname = 'Zanov'), 3),
       (now(), now(), 'Hotel1', 'HOTEL', (select id from authors where name = 'Stojanka' and surname = 'Stojanova'),
        1),
       (now(), now(), 'Motel1', 'MOTEL', (select id from authors where name = 'Ana' and surname = 'Anova'), 4),
       (now(), now(), 'Hotel2', 'HOTEL',
        (select id from authors where name = 'Kiril' and surname = 'Kirilov'), 'GOOD', 6);
