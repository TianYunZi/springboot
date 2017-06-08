package com.boot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.time.Instant;

/**
 * Created by XJX on 2017/6/8.
 * 定时任务
 */
@Service
public class PushServiceImpl implements PushService {

    private DeferredResult<String> deferredResult;

    @Override
    public DeferredResult<String> getAsyncUpdate() {
        deferredResult = new DeferredResult<>();
        return deferredResult;
    }

    @Override
    @Scheduled(fixedDelay = 5000)
    public void refresh() {
        if (deferredResult != null) {
            deferredResult.setResult(new Long(Instant.now().toEpochMilli()).toString());
        }
    }
}
