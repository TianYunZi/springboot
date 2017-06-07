package com.boot.listener;

import com.boot.event.DemoEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by Admin on 2017/6/7.
 * 事件监听器
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent event) {
        String msg = event.getMsg();
        System.out.println("bean-demoListener接收到了bean-demoPublisher发布的消息：" + msg);
    }
}
