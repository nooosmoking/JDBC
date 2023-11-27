package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.List;

public class Message {
    private int id;
    private User author;
    private Chatroom room;
    private String text;
    private LocalDateTime dateTime;

    public Message(int id, User author, Chatroom room, String text, LocalDateTime dateTime){
        this.id = id;
        this.author = author;
        this.room = room;
        this.text = text;
        this.dateTime = dateTime;
    }
}
