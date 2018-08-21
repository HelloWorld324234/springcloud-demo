package com.blog.servicefeign.hystrix;

import com.blog.servicefeign.client.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @Auther: yule
 * @Date: 2018/8/16 0016 09:53
 * @Description:
 */
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {


    @Override
    public String test(String str) {
        return "ERROR--->" + this.getClass().getName() + ":param--->" + str;
    }
}
