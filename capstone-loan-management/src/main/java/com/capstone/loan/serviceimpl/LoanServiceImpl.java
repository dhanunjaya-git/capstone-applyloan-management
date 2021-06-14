package com.capstone.loan.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.loan.entity.LoanDetails;
import com.capstone.loan.entity.LoanType;
import com.capstone.loan.repository.LoanDetailsRepo;
import com.capstone.loan.repository.LoanTypeRepo;
import com.capstone.loan.service.LoanService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanDetailsRepo loanDetailsRepo;
    @Autowired
    private LoanTypeRepo loanTypeRepo;

    @Override
    public Mono<String> applyLoan(LoanDetails loanDetails) {

        Mono<LoanDetails> loanId = loanDetailsRepo.save(loanDetails);
        return loanId.flatMap(loanid->{
        	loanid.getLoanId();
        	return Mono.just("loan applied successfully, your loan id is :" + loanId);
        });
    }

    @Override
    public Mono<LoanDetails> getLoanDetails(Integer userId) {
    	
        Mono<LoanDetails> loanDetails = Optional.ofNullable(loanDetailsRepo.findByCustomerId(userId))
                .orElseThrow(() -> new RuntimeException("loan details are not present , please apply a new loan"));
        return loanDetails;
    }

    @Override
    public Mono<String> saveLoanType(LoanType loanType) {
        Mono<LoanType> loantypes = loanTypeRepo.save(loanType);
        return loantypes.flatMap(loantypeDetails ->{
        	loantypeDetails.getLoanType();
        	return Mono.just("loan type saved successfully, loanType is :" + loantypeDetails);
        });
        
    }

    public Flux<LoanType> getALlLoanTypes(){
        return loanTypeRepo.findAll();
    }
}
