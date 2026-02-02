package com.thiagobritto.finance;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.thiagobritto.finance.domain.Transaction;
import com.thiagobritto.finance.domain.TransactionType;
import com.thiagobritto.finance.repository.TransactionRepository;

public class DataLoader {

	@Bean
	CommandLineRunner loadData(TransactionRepository repository) {
		return args -> {
			Transaction salary = new Transaction(
					"Salary", 
					new BigDecimal("3000.00"), 
					TransactionType.INCOME,
					LocalDate.now());

			repository.save(salary);
		};
	}

}
