package com.blog.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/8/21 0021 16:37
 * @Description:
 */
@SpringBootApplication
@RestController
public class ConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Value("${date}")
    String foo;

    @Value("${democonfigclient.message}")
    String message;

    @RequestMapping(value = "/hi")
    public String hi(){
        return foo;
    }

    @RequestMapping("/message")
    public String message() {
        return "MESSAGE--->" + message;
    }

}
