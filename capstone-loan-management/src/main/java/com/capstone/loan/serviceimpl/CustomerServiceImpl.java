package com.capstone.loan.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.loan.entity.Customer;
import com.capstone.loan.repository.CustomerRepo;
import com.capstone.loan.service.CustomerService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Mono<String> savecustomer(Customer user) {

        Mono<Customer> customerId = customerRepo.save(user);
        return customerId.flatMap(customerid->{
        	customerid.getCustomerId();
         	return Mono.just("user created successfully, your userID is : " + customerid);
        });
    }

    @Override
    public Flux<Customer> getAllcustomers() {
        return customerRepo.findAll();
    }

}
