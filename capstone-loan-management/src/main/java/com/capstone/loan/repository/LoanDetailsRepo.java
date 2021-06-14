package com.capstone.loan.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.capstone.loan.entity.LoanDetails;

import reactor.core.publisher.Mono;

@Repository
public interface LoanDetailsRepo  extends ReactiveCrudRepository<LoanDetails, Integer> {
    Mono<LoanDetails> findByCustomerId(Integer userId);
}
