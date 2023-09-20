package com.information.customer.controllers;

import com.information.customer.model.Customer;
import com.information.customer.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers(){
        return this.customerService.getAllCustomers();
    }

   /* @GetMapping("/name/{name}")
    public List<Customer> getCustomerByName(@PathVariable String name){
        return this.customerService.getCustomersByName(name);
    }*/

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return this.customerService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity putCustomer(@RequestBody Customer customer){
        if(customer.getCustomerId() == null){
            return new ResponseEntity("Entity requires Id for Update", HttpStatus.BAD_REQUEST);
        }else if(this.customerService.getCustomerById(customer.getCustomerId())==null){
            return new ResponseEntity("Entity with given ID not found",HttpStatus.BAD_REQUEST);
        }else{
            this.customerService.updateCustomer(customer);
            return new ResponseEntity(customer, HttpStatus.ACCEPTED);
        }
    }
}
