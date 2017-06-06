package com.boot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Admin on 2017/6/6.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Value("其它类的属性")
    private String author;

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }
}
