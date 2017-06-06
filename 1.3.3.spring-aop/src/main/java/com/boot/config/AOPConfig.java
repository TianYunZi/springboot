package com.boot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Admin on 2017/6/6.
 */
@Configuration
@ComponentScans({@ComponentScan("com.boot.service"), @ComponentScan("com.boot.aop")})
@EnableAspectJAutoProxy
public class AOPConfig {
}
