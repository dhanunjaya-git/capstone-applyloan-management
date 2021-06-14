package com.capstone.loan.service;

import com.capstone.loan.entity.LoanDetails;
import com.capstone.loan.entity.LoanType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LoanService {
	Mono<String> applyLoan(LoanDetails loanDetails);

	Mono<LoanDetails> getLoanDetails(Integer userId);

	Mono<String> saveLoanType(LoanType loanType);

	public Flux<LoanType> getALlLoanTypes();
}
