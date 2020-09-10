package com.customer.records.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerRewardsResponse {

	private long id;
	private String name;
	private long totalRewards;
	private List<TransactionDTO> transactoions;
	private List<String> errors=new ArrayList<>();
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(long totalRewards) {
		this.totalRewards = totalRewards;
	}

	public List<TransactionDTO> getTransactoions() {
		return transactoions;
	}

	public void setTransactoions(List<TransactionDTO> transactoions) {
		this.transactoions = transactoions;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
	

}
