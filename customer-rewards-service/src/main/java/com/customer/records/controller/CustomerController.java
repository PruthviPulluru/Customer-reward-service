package com.customer.records.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.records.exception.RewardsException;
import com.customer.records.model.CustomerDTO;
import com.customer.records.model.CustomerRewardsResponse;
import com.customer.records.service.TransactionService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private TransactionService transactionService;

	@GetMapping
	@ApiOperation("To retrive All the customers")
	public List<CustomerDTO> getAllCustomers() {
		return transactionService.fetcllCustomers();
	}

	@GetMapping("{customerId}/rewards")
	@ApiOperation("To retrive rewards for the given customer")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Returns rewards for the given customer ", response = CustomerRewardsResponse.class),
			@ApiResponse(code = 404, message = "For invalid customer", response = CustomerRewardsResponse.class) })
	public ResponseEntity<CustomerRewardsResponse> getRedeemPoints(@PathVariable Long customerId) {

		try {
			return new ResponseEntity<>(transactionService.calculateRedeemPoints(customerId), HttpStatus.OK);
		} catch (RewardsException e) {
			CustomerRewardsResponse response = new CustomerRewardsResponse();
			response.getErrors().add(e.getMessage());
			return new ResponseEntity<>(response, e.getStatus());

		}

	}
}
