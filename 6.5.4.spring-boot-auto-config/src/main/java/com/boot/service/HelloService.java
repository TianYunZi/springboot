package com.boot.service;

/**
 * Created by XJX on 2017/6/9.
 * 判断依据类
 */
public class HelloService {
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public String sayHello() {
        return "Hello " + msg;
    }
}
