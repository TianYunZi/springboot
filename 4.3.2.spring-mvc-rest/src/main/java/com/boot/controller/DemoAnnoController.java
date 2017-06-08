package com.boot.controller;

import com.boot.model.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Admin on 2017/6/7.
 */
@Controller
@RequestMapping("/anno")
public class DemoAnnoController {

    @RequestMapping(produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String index(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }

    @RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String demoPathVar(@PathVariable String str, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access, str: " + str;
    }

    @RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String passRequestParam(Long id, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access, id: " + id;
    }

    @RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String passObj(DemoObj obj, HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access, obj id: " + obj.getId() + " obj name:" + obj.getName();
    }

    @RequestMapping(value = {"/name1", "/name2"}, produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String remove(HttpServletRequest request) {
        return "url:" + request.getRequestURL() + " can access";
    }
}
