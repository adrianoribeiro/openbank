package com.adrianoribeiro.openbank.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TransactionServiceAPIImpl implements TransactionServiceAPI {

	//TODO Put it in a properties file
	private String urlService = "https://apisandbox.openbankproject.com/obp/v1.2.1/banks/rbs/accounts/savings-kids-john/public/transactions";
	
	@Override
	public JsonNode getJsonFromAPI() throws JsonMappingException, JsonProcessingException {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.getForEntity(urlService, String.class);
		return (new ObjectMapper()).readTree(response.getBody());
	}

}
