DROP SCHEMA IF NOT EXISTS chat;
CREATE SCHEMA IF EXISTS chat;

CREATE TABLE IF NOT EXISTS chat.user (
    id SERIAL PRIMARY KEY NOT NULL,
    login VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS chat.chatroom (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    owner INTEGER NOT NULL REFERENCES chat.user(id)
);

CREATE TABLE IF NOT EXISTS chat.meassage (
    id SERIAL PRIMARY KEY,
    author INTEGER NOT NULL REFERENCES chat.user(id) ,
    room INTEGER NOT NULL REFERENCES chat.chatroom(id),
    "text" TEXT NOT NULL,
    date_time TIMESTAMP
);

CREATE TABLE IF NOT EXISTS chat.user_chat(
    id SERIAL PRIMARY KEY,
    user INTEGER NOT NULL REFERENCES chat.user(id) ,
    room INTEGER NOT NULL REFERENCES chat.chatroom(id),
);