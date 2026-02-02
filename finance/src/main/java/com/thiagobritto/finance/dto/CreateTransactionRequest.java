package com.thiagobritto.finance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.thiagobritto.finance.domain.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CreateTransactionRequest {

	@NotBlank
	private String description;
	
	@NotNull
	@Positive
	private BigDecimal amount;
	
	@NotNull
	private TransactionType type;
	
	@NotNull
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
