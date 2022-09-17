package com.edevapps.rest.demo.data;

import com.edevapps.rest.demo.domain.model.Message;

import java.util.List;

public interface MessageDao {

    List<Message> getAllMessages();

    boolean deleteMessage(Message message);

    boolean existMessage(Message message);

    Message getMessageById(String id);

    Message saveMessage(Message message);
}
