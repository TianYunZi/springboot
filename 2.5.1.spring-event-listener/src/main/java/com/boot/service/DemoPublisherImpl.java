package com.boot.service;

import com.boot.event.DemoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/7.
 */
@Service
public class DemoPublisherImpl implements DemoPublisher {

    @Autowired
    public ApplicationContext applicationContext;

    @Override
    public void publish(String msg) {
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}
