package com.labanovich.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServerService {

    public void receiveMessage(String message) {
        log.info("Server receive message: {}", message);
    }
}

