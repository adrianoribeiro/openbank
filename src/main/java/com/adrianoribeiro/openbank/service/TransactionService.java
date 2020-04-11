package com.adrianoribeiro.openbank.service;

import java.util.List;

import com.adrianoribeiro.openbank.domain.Transaction;

public interface TransactionService {

	public List<Transaction> getAll();
	
	public List<Transaction> findByTransactionType(String transactionType);
	
	public Double totalAmountByTransactionType(String transactionType);
}
