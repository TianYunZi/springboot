package com.boot.message;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by Admin on 2017/6/15.
 */
public class Msg implements MessageCreator {
    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("测试消息");
    }
}
