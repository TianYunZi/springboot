package com.boot.controller;

import com.boot.service.DemoTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Admin on 2017/6/9.
 * 普通测试类
 */
@Controller
public class NormalTestController {

    @Autowired
    public DemoTestService demoTestService;

    @RequestMapping("/normal")
    public String testPage(Model model){
        model.addAttribute("msg",demoTestService.saySomething());
        return "page";
    }
}
