package com.labanovich.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientService {

    public void receiveMessage(String message) {
        log.info("Client receive message: {}", message);
    }
}

