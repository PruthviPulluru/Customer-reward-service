/**
 * 
 */
package com.customer.records.model;

import java.util.Date;

/**
 * @author aravi
 *
 */
public class TransactionDTO {

	private String description;

	private Double amount;

	private Date txDate;
	
	private long rewards;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getTxDate() {
		return txDate;
	}

	public void setTxDate(Date txDate) {
		this.txDate = txDate;
	}

	public long getRewards() {
		return rewards;
	}

	public void setRewards(long rewards) {
		this.rewards = rewards;
	}
	
	

}
