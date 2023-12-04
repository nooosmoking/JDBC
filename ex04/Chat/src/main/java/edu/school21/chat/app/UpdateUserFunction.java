package edu.school21.chat.app;

import edu.school21.chat.models.*;

import java.util.ArrayList;

public class UpdateUserFunction implements UpdateFunction{
    @Override
    public Message update(Message message) {
        message.setAuthor(new User(2L, "user", "user", new ArrayList<Chatroom>(), new ArrayList<Chatroom>()));
        message.setDateTime(null);
        return message;
    }
}
