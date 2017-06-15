package com.boot.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017/6/15.
 */
@Component
public class Reciever {

    @RabbitListener(queues = "my-queue")
    public void receiveMessage(String message) {
        System.out.println("Receive<" + message + ">");
    }
}
