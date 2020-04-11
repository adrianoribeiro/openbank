package com.adrianoribeiro.openbank.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface TransactionServiceAPI {

	public JsonNode getJsonFromAPI() throws JsonMappingException, JsonProcessingException;

}
