package com.thiagobritto.finance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.thiagobritto.finance.domain.TransactionType;

public class CreateTransactionRequest {

	private String description;
	private BigDecimal amount;
	private TransactionType type;
	private LocalDate date;

	public String getDescription() {
		return description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public TransactionType getType() {
		return type;
	}

	public LocalDate getDate() {
		return date;
	}

}
