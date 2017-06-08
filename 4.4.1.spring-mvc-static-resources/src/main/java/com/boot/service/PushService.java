package com.boot.service;

import org.springframework.web.context.request.async.DeferredResult;

/**
 * Created by XJX on 2017/6/8.
 */
public interface PushService {

    DeferredResult<String> getAsyncUpdate();

    void refresh();
}
