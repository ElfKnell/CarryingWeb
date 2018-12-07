CREATE TABLE user
(
    id int PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userName varchar(30) NOT NULL,
    email varchar(60) NOT NULL,
    password varchar(64) NOT NULL,
    phone varchar(10),
    role int NOT NULL COMMENT '1-admin, 2-moderator, 3-ferryman, 4-customer',
    id_order int NOT NULL
);