package com.information.customer.feign.util;

import com.information.customer.model.Policy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="feign", url="https://carehub-quotes.ee-cognizantacademy.com/api")
public interface FeignServiceUtil {

    @GetMapping("/policy/feignTest")
    public String getDemo();

    @GetMapping("/policy/all")
    public List<Policy> getAllPolicies();
}
