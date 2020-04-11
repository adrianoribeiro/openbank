package com.adrianoribeiro.openbank.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianoribeiro.openbank.domain.Transaction;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionServiceAPI transactionServiceAPI;
	
	private Logger log = Logger.getLogger(TransactionServiceImpl.class);
	
	@Override
	public List<Transaction> getAll() {

		try {
			return transformJsonToList(transactionServiceAPI.getJsonFromAPI());
		} catch (IOException e) {
			log.error("An error has occurred while calling transform Json to list", e);
		}

		return Collections.emptyList();
	}

	@Override
	public List<Transaction> findByTransactionType(String transactionType) {
		List<Transaction> transactions = new ArrayList<>();

		try {
			transactions = transformJsonToListAndFilterByTransactionType(transactionServiceAPI.getJsonFromAPI(), transactionType);
		} catch (IOException e) {
			log.error("An error has occurred while calling find by transaction type", e);
		}

		return transactions;
	}

	@Override
	public Double totalAmountByTransactionType(String transactionType) {
		
		final List<Transaction> transactions = findByTransactionType(transactionType);
		return transactions.stream().mapToDouble(transactionItem -> transactionItem.getTransactionAmount()).sum();
	}

	// Private methods
	private List<Transaction> transformJsonToList(JsonNode jsonNode) throws IOException {

		final List<Transaction> transactions = new ArrayList<>();
		jsonNode.get("transactions")
				.forEach(transactionItem -> transactions.add(transformJsonToObject(transactionItem)));

		return transactions;
	}

	private List<Transaction> transformJsonToListAndFilterByTransactionType(JsonNode jsonNode, String transactionType) throws IOException {

		final List<Transaction> transactions = new ArrayList<>();
		jsonNode.get("transactions").forEach(transactionItem -> {
				if (transactionType.equals(transactionItem.at("/details/type").asText())) {
					
					transactions.add(transformJsonToObject(transactionItem));
				}
			});

		return transactions;
	}

	private Transaction transformJsonToObject(JsonNode jsonNode) {

		String valueAmount = jsonNode.at("/details/value/amount").asText();
		
		Transaction transaction = Transaction.builder().id(jsonNode.at("/id").asText())
				.accountId(jsonNode.at("/this_account/id").asText())
				.counterPartyAccount(jsonNode.at("/other_account/number").asText())
				.counterPartyName(jsonNode.at("/other_account/holder/name").asText())
				.counterPartyLogoPath(jsonNode.at("/other_account/metadata/image_URL").asText())
				.instructedAmount(StringUtils.isBlank(valueAmount) ? 0d : Double.valueOf(valueAmount)).instructedCurrency(jsonNode.at("/details/value/currency").asText())
				.transactionAmount(StringUtils.isBlank(valueAmount) ? 0d : Double.valueOf(valueAmount)).transactionCurrency(jsonNode.at("/details/value/currency").asText())
				.transactionType(jsonNode.at("/details/type").asText()).build();

		return transaction;
	}
}
