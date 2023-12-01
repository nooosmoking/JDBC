package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getOwner(){
        return owner;
    }

    public List<Message> getMessages(){
        return messages;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(User owner){
        this.owner = owner;
    }

    public void setMessages(List<Message> messages){
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        else if (o == null || getClass() != o.getClass()) return false;
        Chatroom room = (Chatroom) o;
        return id == room.id &&
                Objects.equals(name, room.name) &&
                Objects.equals(owner, room.owner) &&  Objects.equals(messages, room.messages);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, name, owner, messages);
    }

    @Override
    public String toString(){
        return "Chatroom " + id +": name '" + name +"', owner " + owner + ", messages " +messages;
    }
}
