package com.labanovich.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${queues.client2ServerQueue}")
    private String client2ServerQueue;

    @Value("${queues.server2ClientQueue}")
    private String server2ClientQueue;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(host);
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue client2ServerQueue() {
        return new Queue(client2ServerQueue);
    }

    @Bean
    public Queue server2ClientQueue() {
        return new Queue(server2ClientQueue);
    }

}
