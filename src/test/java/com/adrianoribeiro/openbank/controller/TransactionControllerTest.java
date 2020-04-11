package com.adrianoribeiro.openbank.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.adrianoribeiro.openbank.service.TransactionServiceTestImpl;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TransactionController.class, TransactionServiceTestImpl.class })
public class TransactionControllerTest {

	@Autowired
	public TransactionServiceTestImpl transactionService;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new TransactionController(transactionService)).build();
	}

	@Test
	public void list() throws Exception {

		mockMvc.perform(get("/transactions/")).andExpect(status().isOk());
	}

	@Test
	public void findByTransactionType() throws Exception {

		mockMvc.perform(get("/transactions/Xxx")).andExpect(status().isOk());
	}

	@Test
	public void totalAmount() throws Exception {

		MvcResult result = mockMvc.perform(get("/transactions/Xxx/totalAmount"))
			.andExpect(status().isOk()).andReturn();
		assertEquals("100.0", result.getResponse().getContentAsString());
	}
}
