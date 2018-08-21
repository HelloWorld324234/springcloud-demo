package com.blog.servicehi.client;

import com.blog.servicehi.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: yule
 * @Date: 2018/8/16 0016 10:10
 * @Description:
 */
@Component
@FeignClient(value = "service-hi", fallback = ServiceHiHystrix.HystrixSevcieFallBack.class)
public interface ServiceHiHystrix {

    @GetMapping("hi/user")
    User user();

    @Component
    class HystrixSevcieFallBack implements ServiceHiHystrix {

        @Override
        public User user() {
            return new User("error","error","error");
        }
    }

}
