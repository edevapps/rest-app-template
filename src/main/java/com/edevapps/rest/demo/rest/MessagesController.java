package com.edevapps.rest.demo.rest;

import com.edevapps.rest.demo.domain.model.Message;
import com.edevapps.rest.demo.domain.model.MessageProvider;
import com.edevapps.rest.demo.rest.dto.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/messages")
public class MessagesController {

    private MessageProvider messageProvider;
    @Autowired
    private ConversionService conversion;

    @PostConstruct
    public void init() {
       this.messageProvider = new MessageProvider();
    }

    @GetMapping
    public List<Message> findAllMessages() {
        return  this.messageProvider.getAllMessages();
    }

    @PostMapping
    public MessageDto createMessage(@RequestBody MessageDto dto) {
        Message message = Objects.requireNonNull(
                this.conversion.convert(dto, Message.class));
        message.setId("");
        message.save();
        return this.conversion.convert(message, MessageDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable String id) {
        Message message = this.messageProvider.getMessageById(id);
        message.delete();
    }

    @PutMapping("/{id}")
    public MessageDto updateMessage(@RequestBody MessageDto dto, @PathVariable String id) {
        Message message = this.messageProvider.getMessageById(id);
        message.setText(dto.getText());
        message.save();
        return this.conversion.convert(message, MessageDto.class);
    }
}
