package com.example.whatsappbot.controller;

import com.example.whatsappbot.model.WhatsAppMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    private static final Logger log = LoggerFactory.getLogger(WebhookController.class);

    @PostMapping
    public ResponseEntity<String> receiveMessage(@RequestBody WhatsAppMessage message) {
        log.info("Received message from [{}]: [{}]", message.getSender(), message.getMessageBody());

        String messageBody = message.getMessageBody();
        String response;

        if (messageBody == null) {
            response = "I'm sorry, I only understand 'Hi' and 'Bye'.";
        } else if (messageBody.equalsIgnoreCase("Hi")) {
            response = "Hello";
        } else if (messageBody.equalsIgnoreCase("Bye")) {
            response = "Goodbye";
        } else {
            response = "I'm sorry, I only understand 'Hi' and 'Bye'.";
        }

        return ResponseEntity.ok(response);
    }
}
