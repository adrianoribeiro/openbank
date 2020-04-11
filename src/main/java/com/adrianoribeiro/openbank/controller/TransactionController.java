package com.adrianoribeiro.openbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adrianoribeiro.openbank.domain.Transaction;
import com.adrianoribeiro.openbank.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private TransactionService transactionService;
	
	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}
	
    @GetMapping("/")
    public List<Transaction> list() {

        return transactionService.getAll();
    }
    
    @GetMapping("/{transactionType}")
    public List<Transaction> findByTransactionType(
    		@PathVariable("transactionType") String transactionType) {
    	
        return transactionService.findByTransactionType(transactionType);
    }

    @GetMapping("/{transactionType}/totalAmount")
    public Double totalAmount(
    		@PathVariable("transactionType") String transactionType) {
    	
        return transactionService.totalAmountByTransactionType(transactionType);
    }
}
