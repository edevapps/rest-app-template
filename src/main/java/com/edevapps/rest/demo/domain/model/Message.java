package com.edevapps.rest.demo.domain.model;

public class Message {

    private String id;
    private String text;
    private final MessageProvider provider = new MessageProvider();

    public Message() {
    }

    public Message(String id) {
        this.id = id;
    }

    public Message(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean delete() {
        return this.provider.deleteMessage(this);
    }

    public boolean exist() {
        return this.provider.existMessage(this);
    }

    public void save() {
        Message message = this.provider.saveMessage(this);
        this.id = message.id;
        this.text = message.text;
    }
}
