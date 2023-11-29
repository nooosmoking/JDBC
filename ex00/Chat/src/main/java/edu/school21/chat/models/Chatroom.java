package edu.school21.chat.models;

import java.util.List;

public class Chatroom {
    private int id;
    private String name;
    private User owner;
    private List<Message> messages;

    public Chatroom(int id, String name, User owner,
                    List<Message> messages) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.messages = messages;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    User getOwner(){
        return owner;
    }

    List<Message> getMessages(){
        return messages;
    }

    void setId(int id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

    void setOwner(User owner){
        this.owner = owner;
    }

    void setMessages(List<Message> messages){
        this.messages = messages;
    }
}
