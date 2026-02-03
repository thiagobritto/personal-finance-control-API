package com.thiagobritto.finance.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.thiagobritto.finance.domain.Transaction;
import com.thiagobritto.finance.domain.TransactionType;
import com.thiagobritto.finance.repository.TransactionRepository;

class TransactionServiceTest {

	private TransactionRepository repository;
	private TransactionService service;
	
	@BeforeEach
	void setUp() {
		repository = mock(TransactionRepository.class);
		service = new TransactionService(repository);
	}
	
	@Test
	void shouldCalculateBalanceWithIncomeAndExpence() {
		Transaction income = new Transaction(
				"Salary", 
				new BigDecimal("3000.00"), 
				TransactionType.INCOME, 
				LocalDate.now());
		
		Transaction expence = new Transaction(
				"Rent", 
				new BigDecimal("1200.00"), 
				TransactionType.EXPENSE, 
				LocalDate.now());
		
		when(repository.findAll()).thenReturn(List.of(income, expence));
		
		BigDecimal balance = service.calculateBalance();
		
		assertThat(balance).isEqualByComparingTo("1800.00");
	}
	
	@Test
	void shouldReturnZeroWhenNoTransaction() {
		when(repository.findAll()).thenReturn(List.of());
		
		BigDecimal balance = service.calculateBalance();
		
		assertThat(balance).isEqualByComparingTo("0");
	}
	

}
