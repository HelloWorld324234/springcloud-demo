package com.cloud.eurekaserver.controller;

import com.cloud.eurekaserver.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/8/7 0007 14:31
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/ribbon/{str}")
    public String test(@PathVariable("str") String str) {
        return helloService.test(str);
    }

}
