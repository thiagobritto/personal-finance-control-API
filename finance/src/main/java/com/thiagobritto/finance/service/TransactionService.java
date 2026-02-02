package com.thiagobritto.finance.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.thiagobritto.finance.domain.Transaction;
import com.thiagobritto.finance.domain.TransactionType;
import com.thiagobritto.finance.repository.TransactionRepository;

@Service
public class TransactionService {

	private final TransactionRepository repository;

	public TransactionService(TransactionRepository repository) {
		this.repository = repository;
	}
	
	public Transaction save(Transaction transaction) {
		return repository.save(transaction);
	}
	
	public List<Transaction> findAll() {
		return repository.findAll();
	}
	
	public BigDecimal calculateBalance() {
		return repository.findAll()
				.stream()
				.map(this::signedAmount)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	private BigDecimal signedAmount(Transaction transaction) {
		if (transaction.getType() == TransactionType.EXPENSE) {
			return transaction.getAmount().negate();
		}
		return transaction.getAmount();
	}
	
}
