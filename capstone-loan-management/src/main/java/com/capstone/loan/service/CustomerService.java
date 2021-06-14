package com.capstone.loan.service;

import com.capstone.loan.entity.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {
	Mono<String> savecustomer(Customer user);

	Flux<Customer> getAllcustomers();
}
