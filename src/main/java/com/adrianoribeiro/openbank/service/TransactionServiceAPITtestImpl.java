package com.adrianoribeiro.openbank.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransactionServiceAPITtestImpl implements TransactionServiceAPI {

	@Override
	public JsonNode getJsonFromAPI() throws JsonMappingException, JsonProcessingException{

		return (new ObjectMapper()).readTree(getJsonMock());
	}

	public String getJsonMock() {
		
		StringBuilder sb = new StringBuilder("{\"transactions\": [");
		sb.append(transactionAmount100_SANDBOX_TAN);
		sb.append(",");
		sb.append(transactionAmount50_SANDBOX_TAN);
		sb.append(",");
		sb.append(transactionAmount30_XPTO);
		sb.append("]}");


		return sb.toString();
	}
	
	String transactionAmount100_SANDBOX_TAN = "{\n" + 
			"            \"id\": \"897706c1-dcc6-4e70-9d85-8a537c7cbf3e\",\n" + 
			"            \"this_account\": {\n" + 
			"                \"id\": \"savings-kids-john\",\n" + 
			"                \"holders\": [\n" + 
			"                    {\n" + 
			"                        \"name\": \"Savings - Kids John\",\n" + 
			"                        \"is_alias\": false\n" + 
			"                    }\n" + 
			"                ],\n" + 
			"                \"number\": \"832425-00304050\",\n" + 
			"                \"kind\": \"savings\",\n" + 
			"                \"IBAN\": null,\n" + 
			"                \"swift_bic\": null,\n" + 
			"                \"bank\": {\n" + 
			"                    \"national_identifier\": \"rbs\",\n" + 
			"                    \"name\": \"The Royal Bank of Scotland\"\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"other_account\": {\n" + 
			"                \"id\": \"E806HT1hp-IfBH0DP1rCFrPAftEtpCAwU-XlMo_9bzM\",\n" + 
			"                \"holder\": {\n" + 
			"                    \"name\": \"ALIAS_49532E\",\n" + 
			"                    \"is_alias\": true\n" + 
			"                },\n" + 
			"                \"number\": \"savings-kids-john\",\n" + 
			"                \"kind\": null,\n" + 
			"                \"IBAN\": null,\n" + 
			"                \"swift_bic\": null,\n" + 
			"                \"bank\": {\n" + 
			"                    \"national_identifier\": \"rbs\",\n" + 
			"                    \"name\": \"rbs\"\n" + 
			"                },\n" + 
			"                \"metadata\": {\n" + 
			"                    \"public_alias\": null,\n" + 
			"                    \"private_alias\": null,\n" + 
			"                    \"more_info\": null,\n" + 
			"                    \"URL\": null,\n" + 
			"                    \"image_URL\": null,\n" + 
			"                    \"open_corporates_URL\": null,\n" + 
			"                    \"corporate_location\": null,\n" + 
			"                    \"physical_location\": null\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"details\": {\n" + 
			"                \"type\": \"SANDBOX_TAN\",\n" + 
			"                \"description\": \"Gift\",\n" + 
			"                \"posted\": \"2017-10-15T14:22:28Z\",\n" + 
			"                \"completed\": \"2017-10-15T14:22:28Z\",\n" + 
			"                \"new_balance\": {\n" + 
			"                    \"currency\": \"GBP\",\n" + 
			"                    \"amount\": null\n" + 
			"                },\n" + 
			"                \"value\": {\n" + 
			"                    \"currency\": \"GBP\",\n" + 
			"                    \"amount\": \"100.00\"\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"metadata\": {\n" + 
			"                \"narrative\": null,\n" + 
			"                \"comments\": [],\n" + 
			"                \"tags\": [],\n" + 
			"                \"images\": [],\n" + 
			"                \"where\": null\n" + 
			"            }\n" + 
			"        }";
	String transactionAmount50_SANDBOX_TAN = "        {\n" + 
			"            \"id\": \"a96603e1-7408-485f-8baf-0ff13fdb9655\",\n" + 
			"            \"this_account\": {\n" + 
			"                \"id\": \"savings-kids-john\",\n" + 
			"                \"holders\": [\n" + 
			"                    {\n" + 
			"                        \"name\": \"Savings - Kids John\",\n" + 
			"                        \"is_alias\": false\n" + 
			"                    }\n" + 
			"                ],\n" + 
			"                \"number\": \"832425-00304050\",\n" + 
			"                \"kind\": \"savings\",\n" + 
			"                \"IBAN\": null,\n" + 
			"                \"swift_bic\": null,\n" + 
			"                \"bank\": {\n" + 
			"                    \"national_identifier\": \"rbs\",\n" + 
			"                    \"name\": \"The Royal Bank of Scotland\"\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"other_account\": {\n" + 
			"                \"id\": \"E806HT1hp-IfBH0DP1rCFrPAftEtpCAwU-XlMo_9bzM\",\n" + 
			"                \"holder\": {\n" + 
			"                    \"name\": \"ALIAS_49532E\",\n" + 
			"                    \"is_alias\": true\n" + 
			"                },\n" + 
			"                \"number\": \"savings-kids-john\",\n" + 
			"                \"kind\": null,\n" + 
			"                \"IBAN\": null,\n" + 
			"                \"swift_bic\": null,\n" + 
			"                \"bank\": {\n" + 
			"                    \"national_identifier\": \"rbs\",\n" + 
			"                    \"name\": \"rbs\"\n" + 
			"                },\n" + 
			"                \"metadata\": {\n" + 
			"                    \"public_alias\": null,\n" + 
			"                    \"private_alias\": null,\n" + 
			"                    \"more_info\": null,\n" + 
			"                    \"URL\": null,\n" + 
			"                    \"image_URL\": null,\n" + 
			"                    \"open_corporates_URL\": null,\n" + 
			"                    \"corporate_location\": null,\n" + 
			"                    \"physical_location\": null\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"details\": {\n" + 
			"                \"type\": \"SANDBOX_TAN\",\n" + 
			"                \"description\": \"Birthday Gift\",\n" + 
			"                \"posted\": \"2017-10-15T07:57:48Z\",\n" + 
			"                \"completed\": \"2017-10-15T07:57:48Z\",\n" + 
			"                \"new_balance\": {\n" + 
			"                    \"currency\": \"GBP\",\n" + 
			"                    \"amount\": null\n" + 
			"                },\n" + 
			"                \"value\": {\n" + 
			"                    \"currency\": \"GBP\",\n" + 
			"                    \"amount\": \"50.00\"\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"metadata\": {\n" + 
			"                \"narrative\": null,\n" + 
			"                \"comments\": [],\n" + 
			"                \"tags\": [],\n" + 
			"                \"images\": [],\n" + 
			"                \"where\": null\n" + 
			"            }\n" + 
			"        }";
	
	String transactionAmount30_XPTO = "        {\n" + 
			"            \"id\": \"dcb8138c-eb88-404a-981d-d4edff1086a6\",\n" + 
			"            \"this_account\": {\n" + 
			"                \"id\": \"savings-kids-john\",\n" + 
			"                \"holders\": [\n" + 
			"                    {\n" + 
			"                        \"name\": \"Savings - Kids John\",\n" + 
			"                        \"is_alias\": false\n" + 
			"                    }\n" + 
			"                ],\n" + 
			"                \"number\": \"832425-00304050\",\n" + 
			"                \"kind\": \"savings\",\n" + 
			"                \"IBAN\": null,\n" + 
			"                \"swift_bic\": null,\n" + 
			"                \"bank\": {\n" + 
			"                    \"national_identifier\": \"rbs\",\n" + 
			"                    \"name\": \"The Royal Bank of Scotland\"\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"other_account\": {\n" + 
			"                \"id\": \"NeeYeE-h17DSVCwXpYAz0Zqw7R3X24OkzTe6vBlJcgw\",\n" + 
			"                \"holder\": {\n" + 
			"                    \"name\": \"ALIAS_4DF326\",\n" + 
			"                    \"is_alias\": true\n" + 
			"                },\n" + 
			"                \"number\": \"savings-kids-john\",\n" + 
			"                \"kind\": \"CURRENT PLUS\",\n" + 
			"                \"IBAN\": null,\n" + 
			"                \"swift_bic\": null,\n" + 
			"                \"bank\": {\n" + 
			"                    \"national_identifier\": null,\n" + 
			"                    \"name\": \"rbs\"\n" + 
			"                },\n" + 
			"                \"metadata\": {\n" + 
			"                    \"public_alias\": null,\n" + 
			"                    \"private_alias\": null,\n" + 
			"                    \"more_info\": null,\n" + 
			"                    \"URL\": null,\n" + 
			"                    \"image_URL\": null,\n" + 
			"                    \"open_corporates_URL\": null,\n" + 
			"                    \"corporate_location\": null,\n" + 
			"                    \"physical_location\": null\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"details\": {\n" + 
			"                \"type\": \"XPTO\",\n" + 
			"                \"description\": \"Description abc\",\n" + 
			"                \"posted\": \"2016-10-09T20:01:53Z\",\n" + 
			"                \"completed\": \"2016-10-09T20:01:53Z\",\n" + 
			"                \"new_balance\": {\n" + 
			"                    \"currency\": \"GBP\",\n" + 
			"                    \"amount\": null\n" + 
			"                },\n" + 
			"                \"value\": {\n" + 
			"                    \"currency\": \"GBP\",\n" + 
			"                    \"amount\": \"30.00\"\n" + 
			"                }\n" + 
			"            },\n" + 
			"            \"metadata\": {\n" + 
			"                \"narrative\": null,\n" + 
			"                \"comments\": [],\n" + 
			"                \"tags\": [],\n" + 
			"                \"images\": [],\n" + 
			"                \"where\": null\n" + 
			"            }\n" + 
			"        }";
}
