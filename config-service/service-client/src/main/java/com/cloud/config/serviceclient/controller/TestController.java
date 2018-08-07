package com.cloud.config.serviceclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/8/7 0007 18:52
 * @Description:
 */
@RestController
public class TestController {

    @Value("${foo}")
    String foo;

    @RequestMapping("/hi")
    public String test() {
        return foo;
    }

}
