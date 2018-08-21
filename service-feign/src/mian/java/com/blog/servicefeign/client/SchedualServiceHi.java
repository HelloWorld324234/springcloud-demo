package com.blog.servicefeign.client;

import com.blog.servicefeign.hystrix.SchedualServiceHiHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: yule
 * @Date: 2018/8/15 0015 19:19
 * @Description:
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {

    @GetMapping("/hi/{str}")
    String test(@PathVariable("str") String str);

}
