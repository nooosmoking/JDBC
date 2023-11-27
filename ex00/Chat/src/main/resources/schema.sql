DROP SCHEMA IF NOT EXISTS chat;
CREATE SCHEMA IF EXISTS chat;

CREATE TABLE chat.user (
    id SERIAL PRIMARY KEY,
    login ,
    password
);

CREATE TABLE chat.chatroom (
    id SERIAL PRIMARY KEY,
    login ,
    password
);

CREATE TABLE chat.meassage (
    id SERIAL PRIMARY KEY,
    login ,
    password
);