package com.adrianoribeiro.openbank.service;

import java.util.Arrays;
import java.util.List;

import com.adrianoribeiro.openbank.domain.Transaction;

public class TransactionServiceTestImpl implements TransactionService {

	@Override
	public List<Transaction> getAll() {

		return Arrays.asList(transaction1, transaction2, transaction3);
	}

	@Override
	public List<Transaction> findByTransactionType(String transactionType) {
		
		return Arrays.asList(transaction1, transaction2, transaction3);
	}

	@Override
	public Double totalAmountByTransactionType(String transactionType) {
		
		return 100d;
	}
	
	Transaction transaction1 = Transaction.builder()
			.id("001")
			.accountId("savings-kids-john-001")
			.counterPartyAccount("savings-kids-john-001")
			.counterPartyName("ALIAS_49532E-001")
			.counterPartyLogoPath("001")
			.instructedAmount(100d)
			.instructedCurrency("GBP")
			.transactionAmount(100d)
			.transactionCurrency("GBP")
			.transactionType("SANDBOX_TAN")
			.description("description-001")
			.build();
	
	Transaction transaction2 = Transaction.builder()
			.id("002")
			.accountId("savings-kids-john-002")
			.counterPartyAccount("savings-kids-john-002")
			.counterPartyName("ALIAS_49532E-002")
			.counterPartyLogoPath("002")
			.instructedAmount(100d)
			.instructedCurrency("GBP")
			.transactionAmount(100d)
			.transactionCurrency("GBP")
			.transactionType("SANDBOX_TAN")
			.description("description-002")
			.build();

	Transaction transaction3 = Transaction.builder()
			.id("003")
			.accountId("savings-kids-john-003")
			.counterPartyAccount("savings-kids-john-003")
			.counterPartyName("ALIAS_49532E-003")
			.counterPartyLogoPath("003")
			.instructedAmount(50d)
			.instructedCurrency("GBP")
			.transactionAmount(100d)
			.transactionCurrency("GBP")
			.transactionType("SANDBOX_TAN")
			.description("description-003")
			.build();	

}
