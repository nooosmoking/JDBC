package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public Chatroom getRoom() {
        return room;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setRoom(Chatroom room) {
        this.room = room;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        else if (o == null || getClass() != o.getClass()) return false;
        Message msg = (Message) o;
        return id == msg.id &&
                Objects.equals(author, msg.author) &&
                Objects.equals(room, msg.room) &&  Objects.equals(text, msg.text) && Objects.equals(dateTime, msg.dateTime);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, author, room, text, dateTime);
    }

    @Override
    public String toString(){
        return "Message " + id +": text '" + text +"', author " + author + ", room " +room + ", date and time " + dateTime;
    }
}
