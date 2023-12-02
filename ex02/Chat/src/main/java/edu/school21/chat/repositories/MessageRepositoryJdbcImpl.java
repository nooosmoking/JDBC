package edu.school21.chat.repositories;

import edu.school21.chat.exception.NotSavedSubEntityException;
import edu.school21.chat.models.*;

import java.util.Optional;
import javax.sql.DataSource;

import java.sql.*;


public class MessageRepositoryJdbcImpl implements MessageRepository {
    private DataSource dataSource;

    public MessageRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) {
        try {
            Statement st = dataSource.getConnection().createStatement();
            String query = "SELECT * FROM chat.message WHERE id = " + id;
            ResultSet result = st.executeQuery(query);
            if (!result.next())
                return Optional.empty();
            User user = findUserById(result.getLong("author"));
            Chatroom room = findRoomById(result.getLong("room"));
            return Optional.of(new Message(id, user, room, result.getString("text"), result.getTimestamp("date_time").toLocalDateTime()));

        } catch (Exception ex) {
            System.err.println("Unable to create connection!");
            System.exit(-1);
        }
        return Optional.empty();
    }

    private User findUserById(Long id) {
        try {
            Statement st = dataSource.getConnection().createStatement();
            String query = "SELECT * FROM chat.user WHERE id = " + id;
            ResultSet result = st.executeQuery(query);
            if (!result.next())
                return null;
            return new User(id, result.getString("login"), result.getString("password"), null, null);
        } catch (Exception ex) {
            System.err.println("Unable to create connection!");
            System.exit(-1);
        }
        return null;
    }

    private Chatroom findRoomById(Long id) {
        try {
            Statement st = dataSource.getConnection().createStatement();
            String query = "SELECT * FROM chat.chatroom WHERE id = " + id;
            ResultSet result = st.executeQuery(query);
            if (!result.next())
                return null;
            return new Chatroom(id, result.getString("name"), null, null);
        } catch (Exception ex) {
            System.err.println("Unable to create connection!");
            System.exit(-1);
        }
        return null;
    }

    public void save(Message message) {
        Long user_id = message.getAuthor().getId();
        Long room_id = message.getRoom().getId();
        checkExistence("user", user_id);
        checkExistence("chatroom", room_id);
            try {
                Statement st = dataSource.getConnection().createStatement();
                String query = "INSERT INTO chat.message(\"text\", author, room) VALUES ('" + message.getText() + "', " + user_id + ", " + room_id + ") RETURNING id;";
                ResultSet result = st.executeQuery(query);
                if(!result.next())
                    throw new RuntimeException();
                message.setId(result.getLong(1));
            } catch (Exception ex) {
                System.err.println("Unable to create connection!");
                System.exit(-1);
            }

    }

    private void checkExistence(String table, Long id) {
        ResultSet result = null;
        try {
            Statement st = dataSource.getConnection().createStatement();
            String query = "SELECT * FROM chat." + table + " WHERE id = " + id;
            result = st.executeQuery(query);
        } catch (Exception ex) {
            System.err.println("Unable to create connection!");
            System.exit(-1);
        }
        try {
            if (!result.next()) {
                throw new NotSavedSubEntityException(table + " " + id + "doesn`t exist");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
