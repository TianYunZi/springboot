package com.boot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Admin on 2017/6/7.
 * 计划任务执行类
 */
@Service
public class ScheduleTaskServiceImpl implements ScheduleTaskService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Override
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("每个五秒执行一次 " + DATE_TIME_FORMATTER.format(LocalTime.now()));
    }

    @Override
    @Scheduled(cron = "0 14 15 ? * *")
    public void fixTimeExecution() {
        System.out.println("在指定时间 " + DATE_TIME_FORMATTER.format(LocalTime.now()) + "执行");
    }
}
