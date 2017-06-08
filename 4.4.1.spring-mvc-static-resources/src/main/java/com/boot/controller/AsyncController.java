package com.boot.controller;

import com.boot.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by XJX on 2017/6/8.
 * 演示异步控制器
 */
@Controller
public class AsyncController {

    @Autowired
    public PushService pushService;

    @RequestMapping("/defer")
    @ResponseBody
    public DeferredResult<String> deferredResult() {
        return pushService.getAsyncUpdate();
    }
}
