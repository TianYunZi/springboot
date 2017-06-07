package com.boot.config;

import com.boot.bean.BeanWayService;
import com.boot.bean.JSR250WayService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Admin on 2017/6/7.
 * 配置类
 */
@Configuration
@ComponentScan("com.boot.bean")
public class PrePostConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanWayService beanWayService() {
        return new BeanWayService();
    }

    @Bean
    public JSR250WayService jsr250WayService() {
        return new JSR250WayService();
    }
}
