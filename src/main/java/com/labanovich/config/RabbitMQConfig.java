package com.labanovich.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public ConnectionFactory connectionFactory(){
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public DirectExchange directServer2ClientExchange(){
        return new DirectExchange("server2clientExchange");
    }

    @Bean
    public DirectExchange directClient2ServerExchange(){
        return new DirectExchange("client2serverExchange");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue client2ServerQueue(){
        return new Queue("client2ServerQueue");
    }

    @Bean
    public Queue server2ClientQueue(){
        return new Queue("server2ClientQueue");
    }
}
