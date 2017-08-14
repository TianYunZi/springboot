package com.boot.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017/8/11.
 */
@Aspect
@Component
public class AopComponent {

    private final Logger logger = LoggerFactory.getLogger(AopComponent.class);

    @Pointcut("within(com.boot..*) && @annotation(com.boot.annotation.Action)")
    public void annotationAction() {

    }

    @Before("annotationAction()")
    public void before() {
        logger.info("sayHello方法执行前验证权限");
    }

    @After("annotationAction()")
    public void after() {
        logger.info("sayHello方法执行后记录日志");
    }

}
