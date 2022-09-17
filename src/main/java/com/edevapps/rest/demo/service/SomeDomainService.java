package com.edevapps.rest.demo.service;

import com.edevapps.rest.demo.data.MessageDao;
import com.edevapps.rest.demo.domain.model.Message;
import com.edevapps.rest.demo.domain.service.MessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SomeDomainService implements MessageProviderService {

    @Autowired
    private MessageDao messageDao;

    @Override
    public List<Message> getAllMessages() {
        return this.messageDao.getAllMessages();
    }

    @Override
    public boolean deleteMessage(Message message) {
        return this.messageDao.deleteMessage(message);
    }

    @Override
    public boolean existMessage(Message message) {
        return this.messageDao.existMessage(message);
    }

    @Override
    public Message getMessageById(String id) {
        return this.messageDao.getMessageById(id);
    }

    @Override
    public Message saveMessage(Message message) {
        return this.messageDao.saveMessage(message);
    }
}
