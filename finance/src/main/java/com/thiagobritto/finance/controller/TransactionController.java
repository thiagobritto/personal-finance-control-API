package com.thiagobritto.finance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.thiagobritto.finance.domain.Transaction;
import com.thiagobritto.finance.dto.CreateTransactionRequest;
import com.thiagobritto.finance.dto.TransactionResponse;
import com.thiagobritto.finance.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private final TransactionService service;

	public TransactionController(TransactionService service) {
		this.service = service;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TransactionResponse create(@RequestBody CreateTransactionRequest request) {
		Transaction transaction = new Transaction(
				request.getDescription(), 
				request.getAmount(), 
				request.getType(), 
				request.getDate());
		
		Transaction saved = service.save(transaction);
		
		return toResponse(saved);
	}

	@GetMapping
	public List<TransactionResponse> list() {
		return service.findAll()
				.stream()
				.map(this::toResponse)
				.toList();
	}
	
	@GetMapping("/balance")
	public String balance() {
		return service.calculateBalance().toString();
	}
	
	private TransactionResponse toResponse(Transaction transaction) {
		return new TransactionResponse(
				transaction.getId(), 
				transaction.getDescription(), 
				transaction.getAmount(), 
				transaction.getType(), 
				transaction.getDate());
	}
	
}
