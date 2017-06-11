package com.boot.config;

import com.boot.service.HelloService;
import com.boot.service.HelloServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by XJX on 2017/6/9.
 * 自动配置类
 */
@Configuration
@EnableConfigurationProperties(HelloServiceProperties.class)//开启注入属性，通过@EnableConfigurationProperties声明，使用@Autowired注入
@ConditionalOnClass(HelloService.class)//当HelloService在类路径下时
@ConditionalOnProperty(prefix = "hello", value = "enabled", matchIfMissing = true)
public class HelloServiceAutoConfiguration {

    @Autowired
    private HelloServiceProperties properties;

    @Bean//使用Java配置方式配置HelloService这个Bean
    @ConditionalOnMissingBean(HelloService.class)//容器中没有这个bean时新建bean
    public HelloService helloService() {
        HelloService helloService = new HelloService();
        helloService.setMsg(properties.getMsg());
        return helloService;
    }
}
