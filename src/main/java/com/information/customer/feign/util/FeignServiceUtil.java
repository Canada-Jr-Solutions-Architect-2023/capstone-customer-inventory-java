package com.information.customer.feign.util;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="feign", url="http://localhost:8080/customers")
public interface FeignServiceUtil {

    @GetMapping("/demoName")
    public String getDemo();
}
