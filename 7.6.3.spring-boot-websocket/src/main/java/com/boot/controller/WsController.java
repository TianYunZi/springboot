package com.boot.controller;

import com.boot.model.WiselyMessage;
import com.boot.model.WiselyPesponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * Created by Admin on 2017/6/12.
 * 演示控制器
 */
@Controller
public class WsController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/welcome")//类似于RequestMapping
    @SendTo("/topic/getResponse")//当服务端有消息时，会对订阅了@SendTo中的路径的浏览器发送消息
    public WiselyPesponse say(WiselyMessage message) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new WiselyPesponse("welcome, " + message.getName() + "!");
    }

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        if (principal.getName().equals("wyf")) {
            messagingTemplate.convertAndSendToUser("wisely", "/queue/notifications", principal.getName() + "-send: " + msg);
        } else {
            messagingTemplate.convertAndSendToUser("wyf", "/queue/notifications", principal.getName() + "-send: " + msg);
        }
    }
}
