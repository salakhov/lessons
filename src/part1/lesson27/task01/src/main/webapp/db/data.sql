CREATE TABLE person
(
    id         INT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(250),
    birth_date VARCHAR(250),
    email       VARCHAR(100),
    phone       VARCHAR(20)
);

INSERT INTO person (name,birth_date,email,phone) VALUES ('Vasya','05.09.1981','vasya@vasya','128500');
INSERT INTO person (name,birth_date,email,phone) VALUES ('VAsily Alibabaevich','05.09.1982','vasya@vasya','128500');
INSERT INTO person (name,birth_date,email,phone) VALUES ('Vasilisa','05.09.1983','vasya@vasya','128500');

CREATE TABLE pet
(
    id         INT NOT NULL AUTO_INCREMENT,
    name       VARCHAR(250),
    master     VARCHAR(250),
    type       VARCHAR(100)
);

INSERT INTO pet (name,master,type) VALUES ('Pety','Vasya','dog');

CREATE TABLE JKX
(
    homenumber    VARCHAR(250),
    message       VARCHAR(250)
);

INSERT INTO JKX (homenumber,message) VALUES ('Home1','dog petya was added');