package com.blog.servicehi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/8/15 0015 17:37
 * @Description:
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
@Slf4j
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi/{str}")
    public String home(@PathVariable("str") String str) {
        log.info("ServiceHiApplication:" + "   home" + str);
        return "hi:" + port + "----->" + str;
    }

    @GetMapping("hi/user")
    public User user() {
        User user = new User();
        user.setId("111");
        user.setName("222");
        user.setAddress("333");
        return user;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
