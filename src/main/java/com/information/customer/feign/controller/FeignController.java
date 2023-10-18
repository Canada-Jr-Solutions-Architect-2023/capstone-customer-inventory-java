package com.information.customer.feign.controller;

import com.information.customer.feign.util.FeignServiceUtil;
import com.information.customer.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customerFeign")
public class FeignController {
    @Autowired
    private FeignServiceUtil feignServiceUtil;
    @GetMapping("/policy/feignTest")
    public String getName(){
        return feignServiceUtil.getDemo();
    }
    @GetMapping("/policy/allPolicies")
    public List<Policy> getAllPolicies(){
        return feignServiceUtil.getAllPolicies();
    }
}
