package com.blog.servicehi.service;

import com.blog.servicehi.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: yule
 * @Date: 2018/8/15 0015 17:54
 * @Description:
 */
@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 失败则调用error方法
     *
     * @param str
     * @return
     */
    @HystrixCommand(fallbackMethod = "error")
    public String hiService(String str) {
        return restTemplate.getForObject("http://SERVICE-HI/hi" + str, String.class);
    }

    public User getUser() {
        return restTemplate.getForObject("http://SERVICE-HI/hi/user", User.class);
    }

    public String error(String var1) {
        return "Error-->" + this.getClass().getName() + "&&" + "--->param:" + var1;
    }

}
