package com.labanovich.listener;

import com.labanovich.service.impl.ClientMessageService;
import com.labanovich.service.impl.ServerMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RabbitListener
@Component
@RequiredArgsConstructor
public class RabbitMQListener {

    private final ClientMessageService clientMessageService;
    private final ServerMessageService serverMessageService;

    @RabbitListener(queues = "client2ServerQueue")
    public void proceedClient2ServerQueue(String message){
        serverMessageService.receiveMessage(message);
    }

    @RabbitListener(queues = "server2ClientQueue")
    public void proceedServer2ClientQueue(String message){
        clientMessageService.receiveMessage(message);
    }

}
