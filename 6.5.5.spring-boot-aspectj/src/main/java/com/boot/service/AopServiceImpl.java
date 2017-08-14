package com.boot.service;

import com.boot.annotation.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/8/11.
 */
@Service
public class AopServiceImpl implements AopService {

    private final Logger logger = LoggerFactory.getLogger(AopServiceImpl.class);

    @Override
    @Action(name = "sayHello()方法面向切面")
    public void sayHello() {
        logger.info("Hello, world !");
    }
}
