package com.capstone.loan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.loan.entity.LoanDetails;
import com.capstone.loan.entity.LoanType;
import com.capstone.loan.service.LoanService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService loanService;


    @PostMapping(value = "/applyloan")
    private ResponseEntity<Mono<String>> applyLoan(@RequestBody LoanDetails loanDetails){
        Mono<String> response = loanService.applyLoan(loanDetails);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Mono<LoanDetails>> getLoanDetails(@PathVariable Integer userId){
        Mono<LoanDetails> response = loanService.getLoanDetails(userId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/loanType")
    public ResponseEntity<Mono<String>> createLoanType(@RequestBody LoanType loanType){
       Mono<String> response = loanService.saveLoanType(loanType);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("loanTypes")
    public ResponseEntity<Flux<LoanType>> loanTypes(){
        return ResponseEntity.ok().body(loanService.getALlLoanTypes());
    }


}
