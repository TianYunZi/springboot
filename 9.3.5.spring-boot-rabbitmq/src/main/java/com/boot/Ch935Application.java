package com.boot;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Admin on 2017/6/15.
 */
@SpringBootApplication
public class Ch935Application implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Ch935Application.class, args);
    }

    @Bean
    public Queue wiselyQueue() {
        return new Queue("my-queue");
    }

    @Override
    public void run(String... args) throws Exception {
        rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的的问候");
    }
}
