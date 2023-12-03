package edu.school21.chat.app;

import edu.school21.chat.models.Message;

public class UpdateTextFunction implements UpdateFunction{
    @Override
    public Message update(Message message) {
        message.setText("After tomorrow will send photos");
        message.setDateTime(null);
        return message;
    }
}
