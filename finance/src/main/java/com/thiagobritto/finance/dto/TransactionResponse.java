package com.thiagobritto.finance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.thiagobritto.finance.domain.TransactionType;

public class TransactionResponse {

	private Long id;
	private String description;
	private BigDecimal amount;
	private TransactionType type;
	private LocalDate date;

	public TransactionResponse(Long id, String description, BigDecimal amount, TransactionType type, LocalDate date) {
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.type = type;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

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
