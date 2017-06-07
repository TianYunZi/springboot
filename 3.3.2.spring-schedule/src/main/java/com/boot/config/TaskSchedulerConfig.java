package com.boot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Admin on 2017/6/7.
 * 计划任务配置类
 */
@Configuration
@ComponentScan("com.boot.service")
@EnableScheduling
public class TaskSchedulerConfig {

}
