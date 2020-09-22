DROP TABLE IF EXISTS accident;
DROP TABLE IF EXISTS accident_type;

CREATE TABLE accident_type
(
    id   serial primary key,
    name varchar(2000) NOT NULL
);

CREATE TABLE accident
(
    id               serial primary key,
    name             varchar(2000),
    description      varchar(2000),
    address          varchar(2000),
    accident_type_id INTEGER REFERENCES accident_type

);

-- INSERT INTO accident_type (name)
-- VALUES ('столкновение');
-- INSERT INTO accident_type (name)
-- VALUES ('опрокидывание');
-- INSERT INTO accident_type (name)
-- VALUES ('наезд на пешехода');
--
-- INSERT INTO accident (name, description, address, accident_type_id)
-- VALUES ('Иван', 'Сел за руль без прав', 'ул. Ленина', 1);
-- INSERT INTO accident (name, description, address, accident_type_id)
-- VALUES ('Енокентий', 'Каскадерил', 'пр. Буденого', 2);
-- INSERT INTO accident (name, description, address, accident_type_id)
-- VALUES ('Нафанаил', 'Пьяный за рулем', 'ул. Пушкина', 3);
-- INSERT INTO accident (name, description, address, accident_type_id)
-- VALUES ('Прокоп', 'Сел за руль без очков', 'ул. Якиманка', 1);

