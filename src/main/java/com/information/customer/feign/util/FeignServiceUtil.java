package com.information.customer.feign.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="feign", url="https://carehub-quotes.ee-cognizantacademy.com/api")
public interface FeignServiceUtil {

    @GetMapping("/policy/feignTest")
    public String getDemo();
}
