package com.boot.model;

/**
 * Created by Admin on 2017/6/12.
 * 服务端向浏览器发送的此类消息
 */
public class WiselyPesponse {

    private String responseMessage;

    public WiselyPesponse(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }
}
