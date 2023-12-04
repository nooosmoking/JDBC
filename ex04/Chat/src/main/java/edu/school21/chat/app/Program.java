package edu.school21.chat.app;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import edu.school21.chat.models.*;
import edu.school21.chat.repositories.*;

public class Program {

    public static void main(String[] args) {
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.update("schema.sql");
        dataSource.update("data.sql");
        UsersRepository repository = new UsersRepositoryJdbcImpl(dataSource.getDataSource());
        findAllUsers(repository);
    }
    private static void findAllUsers (UsersRepository repository) {
        List<User> users = repository.findAll(0, 20);
        System.out.println("LIST OF ALL USERS FROM PAGE=0 SIZE=20:");
        users.forEach(System.out::println);

        users = repository.findAll(0, 5);
        System.out.println("\nLIST OF ALL USERS FROM PAGE=0 SIZE=5:");
        users.forEach(System.out::println);

        users = repository.findAll(1, 3);
        System.out.println("\nLIST OF ALL USERS FROM PAGE=1 SIZE=3:");
        users.forEach(System.out::println);

        users = repository.findAll(2, 2);
        System.out.println("\nLIST OF ALL USERS FROM PAGE=2 SIZE=2:");
        users.forEach(System.out::println);

        users = repository.findAll(10, 20);
        System.out.println("\nLIST OF ALL USERS FROM PAGE=10 SIZE=20:");
        users.forEach(System.out::println);
        System.out.println("---MUST BE EMPTY---");
    }

}