CREATE TABLE person
(
    id         INT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(250),
    birth_date VARCHAR(250),
    password   VARCHAR(20)
);

INSERT INTO person (name,birth_date,password) VALUES ('Vasya','05.09.1981','qwerty');
INSERT INTO person (name,birth_date,password) VALUES ('VAsily Alibabaevich','05.09.1982','qwerty');
INSERT INTO person (name,birth_date,password) VALUES ('Vasilisa','05.09.1983','qwerty');