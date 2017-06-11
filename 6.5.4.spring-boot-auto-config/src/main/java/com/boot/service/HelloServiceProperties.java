package com.boot.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by XJX on 2017/6/9.
 * 属性配置
 */
@ConfigurationProperties(prefix = "hello")
public class HelloServiceProperties {

    private static final String MSG = "world";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
