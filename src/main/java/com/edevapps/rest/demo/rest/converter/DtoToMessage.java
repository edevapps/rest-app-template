package com.edevapps.rest.demo.rest.converter;

import com.edevapps.rest.demo.domain.model.Message;
import com.edevapps.rest.demo.rest.dto.MessageDto;
import org.springframework.core.convert.converter.Converter;

public class DtoToMessage implements Converter<MessageDto, Message> {

    @Override
    public Message convert(MessageDto source) {
        return new Message(source.getId(), source.getText());
    }
}
