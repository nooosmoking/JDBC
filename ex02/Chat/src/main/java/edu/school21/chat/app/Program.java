package edu.school21.chat.app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;

public class Program {
    public static void main(String[] args) {
        JDBCDataSource dataSource = new JDBCDataSource();
//        dataSource.update("schema.sql");
//        dataSource.update("data.sql");

        User author = new User(1L, "user", "user", new ArrayList<Chatroom>(), new ArrayList<Chatroom>());
        Chatroom room = new Chatroom(1L, "name", author, new ArrayList<Message>());
        Message message = new Message(null, author, room, "One billion dollars!", LocalDateTime.now());
        MessageRepository messagesRepository = new MessageRepositoryJdbcImpl(dataSource.getDataSource());
        messagesRepository.save(message);
        System.out.println(message.getId());
    }
}