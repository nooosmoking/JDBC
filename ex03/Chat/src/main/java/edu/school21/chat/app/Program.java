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
        MessageRepository messagesRepository = new MessageRepositoryJdbcImpl(dataSource.getDataSource());
        UpdateTextFunction textFunc= new UpdateTextFunction();
        UpdateUserFunction userFunc = new UpdateUserFunction();
        updateData(5L, textFunc, messagesRepository);
        updateData(3L, userFunc, messagesRepository);
    }

    private static void updateData(Long msgId, UpdateFunction function, MessageRepository messagesRepository){
        Optional<Message> messageOptional = messagesRepository.findById(msgId);
        if(messageOptional.isPresent()) {
            Message message = messageOptional.get();
            message = function.update(message);
            messagesRepository.update(message);
            Optional<Message> newMassage = messagesRepository.findById(msgId);
            if(newMassage.isPresent()) {
                System.out.println(message);
            } else {
                System.out.println("Message with id doesn`t exist after changing");
            }
        } else {
            System.out.println("Message with id doesn`t exist");
        }

    }


}