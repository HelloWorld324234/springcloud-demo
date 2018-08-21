package com.blog.servicehi.controller;

import com.blog.servicehi.User;
import com.blog.servicehi.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/8/15 0015 17:56
 * @Description:
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/ribbon/{str}")
    public String test(@PathVariable("str")String str) {
        return helloService.hiService(str);
    }

    @GetMapping("/ribbon/user/{id}")
    public User selectUser(@PathVariable("id")String id) {
        return helloService.getUser();
    }
}
