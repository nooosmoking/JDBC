package edu.school21.chat.app;

import java.util.Optional;
import java.util.Scanner;

import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.*;

public class Program {
    public static void main(String[] args) {
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.update("schema.sql");
        dataSource.update("data.sql");

        System.out.println("Enter a message ID");

        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        long id =  0L;
        try {
            id = Long.parseLong(answer);
        } catch (Exception e) {
            System.err.println("Incorrect id!");
            System.exit(-1);
        }

        MessageRepositoryJdbcImpl massageRepo = new MessageRepositoryJdbcImpl(dataSource.getDataSource());
        Optional<Message> msg = massageRepo.findById(id);
        if (msg.isPresent()) {
            System.out.println(msg.get().toString());
        } else {
            System.out.println("Message with id doesn`t exist");
        }
    }
}