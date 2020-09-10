/**
 * 
 */
package com.customer.records.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.customer.records.domain.Customer;
import com.customer.records.domain.CustomerTransaction;
import com.customer.records.domain.RewardsPointsRange;
import com.customer.records.exception.RewardsException;
import com.customer.records.model.CustomerDTO;
import com.customer.records.model.CustomerRewardsResponse;
import com.customer.records.model.TransactionDTO;
import com.customer.records.repo.CustomerRepo;
import com.customer.records.repo.CustomerTransactionsRepo;
import com.customer.records.repo.RewardsPointsRangeRepo;

@Service
public class TransactionService {

	@Autowired
	private CustomerTransactionsRepo transactionRepo;

	@Autowired
	private RewardsPointsRangeRepo rewardsPointsRangeRepo;

	@Autowired
	private CustomerRepo customerRepo;

	public List<CustomerDTO> fetcllCustomers() {
		return customerRepo.findAll().stream().map(c -> {
			CustomerDTO dto = new CustomerDTO();
			dto.setId(c.getId());
			dto.setName(c.getName());
			return dto;
		}).collect(Collectors.toList());

	}

	public CustomerRewardsResponse calculateRedeemPoints(Long customerId) throws RewardsException {

		CustomerRewardsResponse response = new CustomerRewardsResponse();
		Customer customer = customerRepo.findById(customerId)
				.orElseThrow(() -> new RewardsException(HttpStatus.NOT_FOUND, "Invalid Customer id"));
		// Logic to get last three months date

		Date referenceDate = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(referenceDate);
		c.add(Calendar.MONTH, -3);

		//Retrieving last three months txns
		List<CustomerTransaction> transactions = transactionRepo.findByCustomerAndTxDateAfter(customer, c.getTime());
		
		List<RewardsPointsRange> ranges = rewardsPointsRangeRepo.findAll();

		List<TransactionDTO> transactoionsDto = transactions.stream().map(e -> {
			TransactionDTO dto = new TransactionDTO();
			dto.setDescription(e.getDescription());
			dto.setAmount(e.getAmount());
			dto.setRewards(calculatePoints(ranges, e.getAmount()));
			return dto;
		}).collect(Collectors.toList());
		response.setTotalRewards(transactoionsDto.stream().collect(Collectors.summingLong(e->e.getRewards())));
		response.setTransactoions(transactoionsDto);
		response.setId(customer.getId());
		response.setName(customer.getName());

		return response;

	}

	private Long calculatePoints(List<RewardsPointsRange> ranges, Double amount) {
		AtomicLong points = new AtomicLong(0);

		for (RewardsPointsRange range : ranges) {
			if (range.getPonts() != 0) {
				
				if (range.getMaxAmount() != null) {
					if (amount < range.getMinAmount()) {
						continue;
					} else if (amount > range.getMaxAmount()) {
						points.addAndGet(((Double) (range.getMaxAmount() - range.getMinAmount() + 1)).longValue()
								* range.getPonts());
					} else {
						points.addAndGet(((Double) (amount - range.getMinAmount() + 1)).longValue() * range.getPonts());
					}
				}else {
					if (amount < range.getMinAmount()) {
						continue;
					}else {
						points.addAndGet(((Double) (amount - range.getMinAmount() + 1)).longValue() * range.getPonts());
					}
				}

				
			}

		}

		return points.get();

	}

}
