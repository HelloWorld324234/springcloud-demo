package com.cloud.eurekaserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: yule
 * @Date: 2018/8/7 0007 14:29
 * @Description:
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    public String test(String str) {
        return restTemplate.getForObject("HTTP://SERVICE-HI/hi/" + str, String.class);
    }

}
