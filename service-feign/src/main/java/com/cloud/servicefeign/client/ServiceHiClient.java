package com.cloud.servicefeign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Auther: yule
 * @Date: 2018/8/7 0007 14:57
 * @Description:
 */
@FeignClient(value = "service-hi")
public interface ServiceHiClient {

    @GetMapping("/hi/{str}")
    String test(@PathVariable("str") String str);

}
