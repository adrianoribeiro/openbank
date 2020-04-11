package com.adrianoribeiro.openbank.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.adrianoribeiro.openbank.domain.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TransactionServiceImpl.class, TransactionServiceAPITtestImpl.class })
public class TransactionServiceTest {

	@Autowired
	private TransactionServiceImpl transactionService;

	@Test
	public void getAll() throws JsonMappingException, JsonProcessingException {
		List<Transaction> transactions = transactionService.getAll();
		assertEquals(3,  transactions.size());
	}

	@Test
	public void findByTransactionType_TypeSANDBOX_TAN() throws JsonMappingException, JsonProcessingException {
		List<Transaction> transactions = transactionService.findByTransactionType("SANDBOX_TAN");
		assertEquals(2,  transactions.size());
	}

	@Test
	public void findByTransactionType_TypeXPTO() throws JsonMappingException, JsonProcessingException {
		List<Transaction> transactions = transactionService.findByTransactionType("XPTO");
		assertEquals(1,  transactions.size());
	}
	
	@Test
	public void totalAmountByTransactionType_TypeSANDBOX_TAN() throws JsonMappingException, JsonProcessingException {
		assertEquals(Double.valueOf(150), transactionService.totalAmountByTransactionType("SANDBOX_TAN"));
	}

	@Test
	public void totalAmountByTransactionType_TypeXPTO() throws JsonMappingException, JsonProcessingException {
		assertEquals(Double.valueOf(30), transactionService.totalAmountByTransactionType("XPTO"));
	}
}
