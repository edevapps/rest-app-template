package com.edevapps.rest.demo.data.persistence.converter;

import com.edevapps.rest.demo.data.persistence.entity.Message;
import org.apache.logging.log4j.util.Strings;
import org.springframework.core.convert.converter.Converter;

public class MessageToEntity implements Converter<com.edevapps.rest.demo.domain.model.Message, Message> {

    @Override
    public Message convert(com.edevapps.rest.demo.domain.model.Message source) {
        Long id = Strings.isBlank(source.getId()) ? null : Long.valueOf(source.getId());
        return new Message(id, source.getText());
    }
}
