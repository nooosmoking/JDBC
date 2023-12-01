package edu.school21.chat.app;

import java.util.Scanner;
import edu.school21.chat.repositories.*;

public class Program {
    public static void main(String[] args) {
        System.out.println("Enter a message ID");

        Scanner in = new Scanner(System.in);
        String answer = in.nextLine();
        int id;
        try {
            id = Integer.parseInt(answer);
        } catch (Exception e) {
            System.err.println("Incorrect id!");
            System.exit(-1);
        }
        JDBCDataSource dataSource = new JDBCDataSource();
        dataSource.update("schema.sql");
    }
}