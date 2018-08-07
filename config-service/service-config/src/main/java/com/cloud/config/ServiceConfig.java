package com.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Auther: yule
 * @Date: 2018/8/7 0007 18:18
 * @Description:
 */
@SpringBootApplication
@EnableConfigServer
public class ServiceConfig {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConfig.class, args);
    }

}
