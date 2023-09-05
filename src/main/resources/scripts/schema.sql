create database `momo-tracker`;

use `momo-tracker`;

create table user
(
    id           INT unsigned not null auto_increment,
    name         VARCHAR(100) not null,
    phone_number VARCHAR(15),
    dob          DATE,
    PRIMARY KEY (id),
    UNIQUE KEY (phone_number)
) ENGINE = InnoDB;

create sequence if not exists user_seq start with 1 increment by 50;


create table workout_history
(
    id           INT unsigned not null auto_increment,
    user_id      INT unsigned,
    name         VARCHAR(200) not null,
    note         TEXT,
    steps        INT UNSIGNED not null, -- it ranges from 0 to 4294967295
    created_date DATE not null,
    PRIMARY KEY (id),
    CONSTRAINT `fk_user_workout`
        FOREIGN KEY (user_id) REFERENCES user (id)
            ON DELETE CASCADE
            ON UPDATE RESTRICT
) ENGINE = InnoDB;

create sequence if not exists workout_history_seq start with 1 increment by 50;
