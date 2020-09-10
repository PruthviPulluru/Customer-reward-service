/**
 * 
 */
package com.customer.records.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.records.domain.Customer;
import com.customer.records.domain.CustomerTransaction;

@Repository
public interface CustomerTransactionsRepo extends JpaRepository<CustomerTransaction, Long> {

	List<CustomerTransaction> findByCustomerAndTxDateAfter(Customer customer, Date txDate);

}
