drop table users cascade ;
drop table roles cascade;
DROP TYPE roleType cascade;
drop table user_role cascade;

drop table log cascade;
drop sequence serial;

CREATE TABLE users (
    id              INTEGER,
    name            varchar(80),
    birthday        TIMESTAMP,
    loginId         varchar(20) UNIQUE NOT NULL,
    city            varchar(20),
    email           varchar(20) UNIQUE NOT NULL,
    description     varchar(100),
    PRIMARY KEY (id)
);

CREATE TYPE roleType AS ENUM ('Administration', 'Clients', 'Billing');

CREATE TABLE roles (
    id INTEGER,
    name roleType,
    PRIMARY KEY (id)

);

CREATE table user_role (
    id      INTEGER,
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) references users(id),
    FOREIGN KEY (role_id) references roles(id)
);

CREATE TABLE LOG (
                      id INTEGER ,
                      date TIMESTAMP,
                      log_level VARCHAR(32),
                      message VARCHAR(4000),
                      exception VARCHAR(255)
);
CREATE SEQUENCE serial START 1;
INSERT INTO users(id, name, birthday, loginId, city, email, description) VALUES (1, 'Kurikin Ivan Ivanovish', '2014-04-04', 'kurikin', 'Tver', 'kirikin@mail.ru','Человек');