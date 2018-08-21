package com.blog.servicezuul;

import com.blog.servicezuul.zuul.AccessPasswordFilter;
import com.blog.servicezuul.zuul.AccessUserNameFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: yule
 * @Date: 2018/8/16 0016 11:40
 * @Description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableEurekaClient
public class ServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }

    @Bean
    public AccessUserNameFilter accessUserNameFilter() {
        return new AccessUserNameFilter();
    }

    @Bean
    public AccessPasswordFilter accessPasswordFilter() {
        return new AccessPasswordFilter();
    }

}
