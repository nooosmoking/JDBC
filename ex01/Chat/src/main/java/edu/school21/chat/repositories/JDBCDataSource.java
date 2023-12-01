package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.app.Program;

import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;

public class JDBCDataSource {
    private final String user = "nooo_sm";
    private final String password = "x";
    private final String url = "jdbc:postgresql://localhost:5432/nooo_sm";
    HikariDataSource dataSource;
    private Connection connection;

    public JDBCDataSource(){
        HikariConfig config = new HikariConfig();
        try{
            config.setJdbcUrl(url);
            config.setUsername(user);
            config.setPassword(password);

            dataSource = new HikariDataSource(config);
            connection = dataSource.getConnection();}
        catch(Exception ex){
            System.err.println("Error to create connection");
            System.exit(-1);
        }
    }

    public Connection getConnection(){
        return connection;
    }
    public void update(String filename){
        try {
            Statement st = connection.createStatement();
            InputStream in = Program.class.getClassLoader().getResourceAsStream(filename);
            if(in != null) {
                Scanner scanner = new Scanner(in);
                scanner.useDelimiter(";");
                while (scanner.hasNext())
                    st.executeUpdate(scanner.next().trim());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.err.println("Error to update " + filename);
            System.exit(-1);
        }
    }
}