package com.boot.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.Instant;

/**
 * Created by Admin on 2017/6/8.
 */
public class DemoInterceptor extends HandlerInterceptorAdapter {

    private static Logger logger = LoggerFactory.getLogger(DemoInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Instant startTime = Instant.now();
        request.setAttribute("startTime", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Instant startTime = (Instant) request.getAttribute("startTime");
        request.removeAttribute("startTime");
        Instant endTime = Instant.now();
        long millis = Duration.between(startTime, endTime).toMillis();
        logger.info("本次请求处理时间为：" + millis + "ms");
        request.setAttribute("handlingTime", millis);
    }
}
