package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private List<Chatroom> createdRooms;
    private List<Chatroom> communicateRooms;

    public User(int id, String login, String password,
                    List<Chatroom> createdRooms, List<Chatroom> communicateRooms){
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.communicateRooms = communicateRooms;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    public List<Chatroom> getCommunicateRooms() {
        return communicateRooms;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    public void setCommunicateRooms(List<Chatroom> communicateRooms) {
        this.communicateRooms = communicateRooms;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        else if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&  Objects.equals(createdRooms, user.createdRooms) && Objects.equals(communicateRooms, user.communicateRooms);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, login, password, createdRooms, communicateRooms);
    }

    @Override
    public String toString(){
        return "Message " + id +": login " + login +", password " + password + ", rooms crested by user " +createdRooms + ", rooms where user socialized " + communicateRooms;
    }
}
