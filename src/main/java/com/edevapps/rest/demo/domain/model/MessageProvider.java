package com.edevapps.rest.demo.domain.model;

import com.edevapps.rest.demo.domain.service.MessageProviderService;

import java.util.List;

import static com.edevapps.rest.demo.domain.ContextHolder.context;

public class MessageProvider {
    
    public List<Message> getAllMessages() {
        return service().getAllMessages();
    }
    public boolean deleteMessage(Message message) {
        return service().deleteMessage(message);
    }

    public boolean existMessage(Message message) {
        return service().existMessage(message);
    }

    public Message getMessageById(String id) {
        return service().getMessageById(id);
    }

    public Message saveMessage(Message message) {
        return service().saveMessage(message);
    }
    
    private MessageProviderService service() {
        return context().instance(MessageProviderService.class);
    }
}
