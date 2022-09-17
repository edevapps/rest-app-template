package com.edevapps.rest.demo.domain.service;

import com.edevapps.rest.demo.domain.model.Message;

import java.util.List;

public interface MessageProviderService {

    List<Message> getAllMessages();
    boolean deleteMessage(Message message);

    boolean existMessage(Message message);

    Message getMessageById(String id);

    Message saveMessage(Message message);
}
