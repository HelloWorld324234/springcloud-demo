package com.cloud.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/8/7 0007 09:45
 * @Description:
 */
@RestController
public class TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi/{str}")
    public String home(@PathVariable("str") String str) {
        return str + ":" + port;
    }
 }
