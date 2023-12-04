package edu.school21.chat.repositories;

import edu.school21.chat.exception.NotSavedSubEntityException;
import edu.school21.chat.models.*;

import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

import java.sql.*;


public class UsersRepositoryJdbcImpl implements UsersRepository {
    private Connection con;
    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        try {
            this.con = dataSource.getConnection();
        } catch (Exception ex){
            System.err.println("Unable to create connection!");
            System.exit(-1);
        }
    }

    @Override
    public List<User> findAll(int page, int size) {
        String query ="SELECT u.*, ch.*, user_chatroom.* " +
                "FROM (SELECT * FROM chat.\"user\" LIMIT ? OFFSET ? ORDER BY user.id) AS u," +
                "LEFT JOIN chat.chatroom ch ON ch.owner = u.id" +
                "LEFT JOIN chat.user_chatroom uc ON uc.user_id = u.id" +
                "LEFT JOIN chat.user_chatroom cu ON cu.room_id = ch.id" +
                "ORDER BY u.id, ch.id";
        try {
            Statement st = con.createStatement();

            ResultSet result = st.executeQuery(query);
            if (!result.next())
                return null;
            User user = findUserById(result.getLong("author"));
            Chatroom room = findRoomById(result.getLong("room"));
            return Optional.of(new Message(id, user, room, result.getString("text"), result.getTimestamp("date_time").toLocalDateTime()));

        } catch (Exception ex) {
            System.out.println("Error executing the query");
        }

        return null;
    }

    private User findUserById(Long id) {
        try {
            Statement st = con.createStatement();
            String query = "SELECT * FROM chat.user WHERE id = " + id;
            ResultSet result = st.executeQuery(query);
            if (!result.next())
                return null;
            return new User(id, result.getString("login"), result.getString("password"), null, null);
        } catch (Exception ex) {
            System.out.println("Error executing the query");
        }
        return null;
    }



}
