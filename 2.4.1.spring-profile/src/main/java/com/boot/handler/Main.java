package com.boot.handler;

import com.boot.bean.DemoBean;
import com.boot.config.ProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Admin on 2017/6/7.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfig.class);
        context.refresh();
        DemoBean de = context.getBean(DemoBean.class);
        System.out.println(de.getContent());
        context.close();
    }
}
