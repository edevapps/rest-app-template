package com.edevapps.rest.demo.rest.converter;

import com.edevapps.rest.demo.domain.model.Message;
import com.edevapps.rest.demo.rest.dto.MessageDto;
import org.springframework.core.convert.converter.Converter;

public class MessageToDto implements Converter<Message, MessageDto> {

    @Override
    public MessageDto convert(Message source) {
        return new MessageDto(source.getId(), source.getText());
    }
}
