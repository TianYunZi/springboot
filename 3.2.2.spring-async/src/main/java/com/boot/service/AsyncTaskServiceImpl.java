package com.boot.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/7.
 * 任务执行类
 */
@Service
public class AsyncTaskServiceImpl implements AsyncTaskService {

    @Async
    @Override
    public void executeAsyncTask(Integer integer) {
        System.out.println("执行异步任务：" + integer);
    }

    @Async
    @Override
    public void executeAsyncTaskPlus(Integer integer) {
        System.out.println("执行异步任务+1：" + (integer + 1));
    }
}
