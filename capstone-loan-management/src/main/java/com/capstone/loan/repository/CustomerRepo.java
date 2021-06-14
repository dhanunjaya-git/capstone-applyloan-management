package com.capstone.loan.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.capstone.loan.entity.Customer;

@Repository
public interface CustomerRepo extends ReactiveCrudRepository<Customer, Integer> {

}
