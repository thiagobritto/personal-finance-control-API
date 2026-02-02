package com.thiagobritto.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiagobritto.finance.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
