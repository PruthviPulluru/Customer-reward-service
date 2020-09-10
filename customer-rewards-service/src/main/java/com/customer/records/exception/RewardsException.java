/**
 * 
 */
package com.customer.records.exception;

import org.springframework.http.HttpStatus;

public class RewardsException extends Exception {

	private HttpStatus status;

	public RewardsException(HttpStatus status, String msg) {
		super(msg);
		this.status = status;

	}

	public HttpStatus getStatus() {
		return status;
	}

	
	

}
