package com.edevapps.rest.demo.data.persistence.converter;

import com.edevapps.rest.demo.data.persistence.entity.Message;
import org.springframework.core.convert.converter.Converter;

public class EntityToMessage implements Converter<Message, com.edevapps.rest.demo.domain.model.Message> {

    @Override
    public com.edevapps.rest.demo.domain.model.Message convert(Message source) {
        String id = source.getId() == null ? "" : String.valueOf(source.getId());
        return new com.edevapps.rest.demo.domain.model.Message(id, source.getText());
    }
}
