/**
 * 
 */
package com.customer.records.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rewards_range")
public class RewardsPointsRange {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "min_amt")
	private Double minAmount;

	@Column(name = "max_amt")
	private Double maxAmount;

	@Column(name = "points")
	private int ponts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}

	public Double getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public int getPonts() {
		return ponts;
	}

	public void setPonts(int ponts) {
		this.ponts = ponts;
	}
	
	

}
