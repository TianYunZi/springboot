package com.boot.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/15.
 */
@Service
public class ScheduledTaskService {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importJob;

    private JobParameters jobParameters;

    @Scheduled(fixedRate = 5000)
    public void execute() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        jobLauncher.run(importJob, jobParameters);
    }
}
