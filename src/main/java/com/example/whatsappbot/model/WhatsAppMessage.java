package com.example.whatsappbot.model;

public class WhatsAppMessage {
    private String sender;
    private String messageBody;

    public WhatsAppMessage() {
    }

    public WhatsAppMessage(String sender, String messageBody) {
        this.sender = sender;
        this.messageBody = messageBody;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
