package com.boot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Admin on 2017/6/7.
 */
@Configuration
@ComponentScans({@ComponentScan("com.boot.listener"),@ComponentScan("com.boot.service")})
public class EventConfig {
}
