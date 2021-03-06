package com.boot.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Admin on 2017/6/8.
 * SSE演示控制器.
 */
@Controller
public class SseController {

    @RequestMapping(value = "/push", produces = "text/event-stream;charset=utf-8")
    @ResponseBody
    public String push() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + random.nextInt() + "\n\n";
    }
}
