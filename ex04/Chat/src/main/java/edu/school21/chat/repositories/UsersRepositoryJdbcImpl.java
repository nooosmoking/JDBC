package edu.school21.chat.repositories;

import edu.school21.chat.exception.NotSavedSubEntityException;
import edu.school21.chat.models.*;

import java.util.ArrayList;
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
        List<User> listUsers = new ArrayList<>();
        String query ="SELECT u.*, cr_r.id AS create_room_id, cr_r.name AS create_room_name, soc_r.id  AS social_room_id, soc_r.name AS social_room_name\n" +
                "                 FROM (SELECT * FROM chat.\"user\" ORDER BY \"user\".id LIMIT ? OFFSET ?) AS u\n" +
                "                 LEFT JOIN chat.chatroom cr_r ON cr_r.owner = u.id \n" +
                "                 LEFT JOIN chat.user_chatroom uc ON uc.user_id = u.id \n" +
                "                 LEFT JOIN chat.chatroom soc_r ON uc.room_id = soc_r.id \n" +
                "                 ORDER BY u.id, create_room_id, social_room_id;";
        int offset  = page * size;
        try {
            PreparedStatement st = con.prepareStatement(query);
            st.setLong(1, size);
            st.setLong(2, offset);
            ResultSet result = st.executeQuery(query);
            while (result.next()){
                Long userId = result.getLong("u.id");
                Long createRoomId = result.getLong("create_room_id");
                Long socialRoomId = result.getLong("social_room_id");
                if(listUsers.isEmpty() ||  !listUsers.stream().anyMatch(user -> user.getId().equals(userId))){
                    Chatroom createRoom = new Chatroom(createRoomId, result.getString("create_room_name"), null, null);
                    Chatroom socialRoom = new Chatroom(socialRoomId, result.getString("social_room_name"), null, null);
                    User currUser = new User(userId, result.getString("u.login"),  result.getString("u.password"), new ArrayList<Chatroom>(), new ArrayList<Chatroom>());
                    currUser.addCommunicateRoom(socialRoom);
                    currUser.addCreatedRoom(createRoom);
                }

            }
        } catch (Exception ex) {
            System.out.println("Error executing the query");
        }
        return users;
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
