package com.labanovich.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ServerController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/send2client")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        log.info("Emit to server2ClientQueue");
        rabbitTemplate.convertAndSend("server2ClientQueue", message);
        return ResponseEntity.ok("message sent");
    }
}
