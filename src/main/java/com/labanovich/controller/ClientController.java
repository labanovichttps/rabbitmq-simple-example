package com.labanovich.controller;

import com.labanovich.service.ClientService;
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
public class ClientController {

    private final RabbitTemplate rabbitTemplate;

    @PostMapping("/send2server")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        log.info("Emit to client2serverQueue");
        rabbitTemplate.convertAndSend("client2ServerQueue", message);
        return ResponseEntity.ok("message sent");
    }
}
