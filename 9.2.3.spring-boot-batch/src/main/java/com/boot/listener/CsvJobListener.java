package com.boot.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by Admin on 2017/6/15.
 * Job监听
 */
public class CsvJobListener implements JobExecutionListener {

    private Instant start;

    private Instant end;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        start = Instant.now();
        System.out.println("任务开始处理");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        end = Instant.now();
        System.out.println("任务处理结束");
        System.out.println("耗时：" + Duration.between(start, end).toMillis() + "ms");
    }
}
