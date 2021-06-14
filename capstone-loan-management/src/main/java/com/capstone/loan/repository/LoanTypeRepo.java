package com.capstone.loan.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.capstone.loan.entity.LoanType;

@Repository
public interface LoanTypeRepo extends ReactiveCrudRepository<LoanType, Integer> {
}
