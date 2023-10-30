package com.information.customer.feign.controller;

import com.information.customer.feign.util.FeignServiceUtil;
import com.information.customer.model.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/customerFeign")
public class FeignController {
    private static final Logger logger = LoggerFactory.getLogger(FeignController.class);
    @Autowired
    private FeignServiceUtil feignServiceUtil;
    @GetMapping("/policy/feignTest")
    public String getName(){
        return feignServiceUtil.getDemo();
    }
    @GetMapping("/policy/allPolicies")
    public List<Policy> getAllPolicies(){
        logger.info("Fetching all policies from carehub quotes api.");
        return feignServiceUtil.getAllPolicies();
    }
}