package com.example.demo.controller;

import com.example.demo.customlistener.MyEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ListenerController {

    @Resource
    ApplicationContext applicationContext;

    @RequestMapping("/publish")
    public String hello() {
        // TODO 业务处理

        applicationContext.publishEvent(new MyEvent("邮件内容"));

        return "ok";
    }
}
