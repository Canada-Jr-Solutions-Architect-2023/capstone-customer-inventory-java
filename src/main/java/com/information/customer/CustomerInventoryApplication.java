package com.information.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomerInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerInventoryApplication.class, args);
    }

}
