package com.blog.servicefeign.controller;

import com.blog.servicefeign.client.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yule
 * @Date: 2018/8/15 0015 19:42
 * @Description:
 */
@RestController
public class HiController {

    @Autowired
    private SchedualServiceHi schedualServiceHi;

    @GetMapping("/feign/{str}")
    public String test(@PathVariable("str")String str) {
        return schedualServiceHi.test(str);
    }


}
