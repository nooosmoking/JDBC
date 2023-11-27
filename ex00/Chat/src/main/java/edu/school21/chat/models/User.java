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
}
