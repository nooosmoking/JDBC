package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private int id;
    private String name;
    private User owner;
    private List<Message> messages;

    public Chatroom(int id, String name, User owner,
    List<Message> messages){
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.messages = messages;
    }
}
