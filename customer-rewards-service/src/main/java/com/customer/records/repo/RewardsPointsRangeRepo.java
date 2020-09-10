package com.customer.records.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customer.records.domain.RewardsPointsRange;

@Repository
public interface RewardsPointsRangeRepo extends JpaRepository<RewardsPointsRange, Long> {

}
