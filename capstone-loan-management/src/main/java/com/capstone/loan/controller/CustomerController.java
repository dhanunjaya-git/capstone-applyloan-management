package com.capstone.loan.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.loan.entity.Customer;
import com.capstone.loan.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping
    private ResponseEntity<Mono<String>> crateNewCustomer(@RequestBody Customer customer) {
        Mono<String> response = customerService.savecustomer(customer);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/users")
    public ResponseEntity<Flux<Customer>> getAllcustomers(){
        return ResponseEntity.ok().body(customerService.getAllcustomers());
    }
}
