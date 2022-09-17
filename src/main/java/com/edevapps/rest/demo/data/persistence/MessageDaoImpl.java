package com.edevapps.rest.demo.data.persistence;

import com.edevapps.rest.demo.data.MessageDao;
import com.edevapps.rest.demo.data.persistence.entity.Message;
import com.edevapps.rest.demo.data.persistence.repository.MessagesRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MessageDaoImpl implements MessageDao {

    @Autowired
    private MessagesRepository repository;
    @Autowired
    private ConversionService conversion;

    @Override
    public List<com.edevapps.rest.demo.domain.model.Message> getAllMessages() {
        List<Message> result = new ArrayList<>(this.repository.findAll());
        return result.stream().map(message ->
                conversion.convert(message, com.edevapps.rest.demo.domain.model.Message.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public boolean deleteMessage(com.edevapps.rest.demo.domain.model.Message message) {
        Objects.requireNonNull(message);
        Long id = Long.valueOf(message.getId());
        if(!this.repository.existsById(id)) {
            return false;
        }
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public boolean existMessage(com.edevapps.rest.demo.domain.model.Message message) {
        Objects.requireNonNull(message);
        return this.repository.existsById(Long.valueOf(message.getId()));
    }

    @Override
    public com.edevapps.rest.demo.domain.model.Message getMessageById(String id) {
        Strings.isNotBlank(id);
        return this.repository.findById(Long.valueOf(id)).map(value -> this.conversion
                .convert(value, com.edevapps.rest.demo.domain.model.Message.class))
                .orElse(null);
    }

    @Override
    public com.edevapps.rest.demo.domain.model.Message saveMessage(com.edevapps.rest.demo.domain.model.Message message) {
        Objects.requireNonNull(message);
        Message entity = this.repository.save(Objects.requireNonNull(this.conversion.convert(message, Message.class)));
        return this.conversion.convert(entity, com.edevapps.rest.demo.domain.model.Message.class);
    }
}
