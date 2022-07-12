package com.labanovich.service.impl;

import com.labanovich.service.interfaces.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServerMessageService implements MessageService {

    private final RabbitTemplate rabbitTemplate;

    public void receiveMessage(String message) {
        log.info("Server receive message: {}", message);
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("server2ClientQueue", message);
    }
}

