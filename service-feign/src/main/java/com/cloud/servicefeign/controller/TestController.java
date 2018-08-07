package com.cloud.servicefeign.controller;

import com.cloud.servicefeign.client.ServiceHiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/8/7 0007 14:56
 * @Description:
 */
@RestController
public class TestController {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错
    @Autowired
    private ServiceHiClient serviceHiClient;

    @GetMapping("/feign/{str}")
    public String test(@PathVariable("str") String str) {
        return serviceHiClient.test(str);
    }

}
