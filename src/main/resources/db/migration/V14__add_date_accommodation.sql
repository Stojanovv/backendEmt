ALTER TABLE accommodations
    ADD COLUMN date_opened DATE;

UPDATE accommodations SET date_opened = '2018-05-10' WHERE name = 'Villa Lake';
UPDATE accommodations SET date_opened = '2020-03-15' WHERE name = 'City Apartment';
UPDATE accommodations SET date_opened = '2012-11-01' WHERE name = 'Tokyo Hotel';
UPDATE accommodations SET date_opened = '2016-07-20' WHERE name = 'Paris Stay';
UPDATE accommodations SET date_opened = '2019-09-05' WHERE name = 'Berlin House';
UPDATE accommodations SET date_opened = '2021-01-12' WHERE name = 'Rome Flat';
UPDATE accommodations SET date_opened = '2014-06-30' WHERE name = 'Santiago Lodge';
UPDATE accommodations SET date_opened = '2017-08-18' WHERE name = 'Rio Hostel';
UPDATE accommodations SET date_opened = '2013-12-25' WHERE name = 'Toronto Inn';
UPDATE accommodations SET date_opened = '2022-04-01' WHERE name = 'Sydney Villa';