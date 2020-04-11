package com.adrianoribeiro.openbank.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {

	private String id; //id
	
	@JsonProperty("account_id")
	private String accountId; // this_account.id
	
	@JsonProperty("counter_party_account")
	private String counterPartyAccount; // other_account.number
	
	@JsonProperty("counter_party_name")
	private String counterPartyName; // other_account.holder.name
	
	@JsonProperty("counterParty_logo_path")
	private String counterPartyLogoPath; // other_account.metadata.image_URL
	
	@JsonProperty("instructed_amount")
	private Double instructedAmount; // details.value.amount
	
	@JsonProperty("instructed_currency")
	private String instructedCurrency; // details.value.currency
	
	@JsonProperty("transaction_amount")
	private Double transactionAmount; // details.value.amount
	
	@JsonProperty("transaction_currency")
	private String transactionCurrency; // details.value.currency
	
	@JsonProperty("transaction_type")
	private String transactionType; // details.type
	
	private String description; // details.description
	
}
