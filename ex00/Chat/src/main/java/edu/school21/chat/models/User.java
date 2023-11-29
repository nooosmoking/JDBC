package edu.school21.chat.models;

import java.util.List;

public class User {
    private int id;
    private String login;
    private String password;
    List<Chatroom> createdRooms;
    List<Chatroom> communicateRooms;

    public User(int id, String login, String password,
                    List<Chatroom> createdRooms, List<Chatroom> communicateRooms){
        this.id = id;
        this.login = login;
        this.password = password;
        this.createdRooms = createdRooms;
        this.communicateRooms = communicateRooms;
    }

    int getId() {
        return id;
    }

    String getLogin() {
        return login;
    }

    String getPassword() {
        return password;
    }

    List<Chatroom> getCreatedRooms() {
        return createdRooms;
    }

    List<Chatroom> getCommunicateRooms() {
        return communicateRooms;
    }

    void setId(int id) {
        this.id = id;
    }

    void setLogin(String login) {
        this.login = login;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void setCreatedRooms(List<Chatroom> createdRooms) {
        this.createdRooms = createdRooms;
    }

    void setCommunicateRooms(List<Chatroom> communicateRooms) {
        this.communicateRooms = communicateRooms;
    }
}
