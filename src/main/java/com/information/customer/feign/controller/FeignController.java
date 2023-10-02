package com.information.customer.feign.controller;

import com.information.customer.feign.util.FeignServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerFeign")
public class FeignController {
    @Autowired
    private FeignServiceUtil feignServiceUtil;
    @GetMapping("/demo-name")
    public String getName(){
        return feignServiceUtil.getDemo();
    }
}
