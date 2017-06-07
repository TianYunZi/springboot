package com.boot.configuration;

import com.boot.condition.LinuxCondition;
import com.boot.condition.WindowsCondition;
import com.boot.service.LinuxListService;
import com.boot.service.ListService;
import com.boot.service.WindowsListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Admin on 2017/6/7.
 * 配置类
 */
@Configuration
public class ConditionConfig {

    @Bean
    @Conditional(WindowsCondition.class)
    public ListService windowsListService() {
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListService();
    }
}
