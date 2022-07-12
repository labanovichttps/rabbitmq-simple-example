package com.labanovich.listener;

import com.labanovich.service.ClientService;
import com.labanovich.service.ServerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@RabbitListener
@Component
@RequiredArgsConstructor
public class RabbitMQListener {

    private final ClientService clientService;
    private final ServerService serverService;

    @RabbitListener(queues = "client2ServerQueue")
    public void proceedClient2ServerQueue(String message){
        serverService.receiveMessage(message);
    }

    @RabbitListener(queues = "server2ClientQueue")
    public void proceedServer2ClientQueue(String message){
        clientService.receiveMessage(message);
    }

}
