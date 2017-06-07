package com.boot.service;

/**
 * Created by Admin on 2017/6/7.
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
