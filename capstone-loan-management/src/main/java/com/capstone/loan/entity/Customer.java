package com.capstone.loan.entity;

import java.time.LocalDate;
import java.util.Collection;

public class Customer {
	private Integer customerId;
	private String customerName;
	private String address;
	private LocalDate createdDate;
	private LocalDate updatedDate;
	private Integer createdBy;
	private Integer updatedBy;
	private Integer id;

	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDate updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

//	@OneToMany(mappedBy = "user")
	private Collection<LoanDetails> loanDetails;

	public Collection<LoanDetails> getLoanDetails() {
		return loanDetails;
	}

	public void setLoanDetails(Collection<LoanDetails> loanDetails) {
		this.loanDetails = loanDetails;
	}
}
