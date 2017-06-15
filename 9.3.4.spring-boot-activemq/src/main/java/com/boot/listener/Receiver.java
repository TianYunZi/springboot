package com.boot.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017/6/15.
 */
@Component
public class Receiver {

    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message) {
        System.out.println("接受到：<" + message + ">");
    }
}
