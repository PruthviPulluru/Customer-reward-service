package com.customer.records;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class RewardsApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void testAllCustomers() throws Exception {
		ResultActions result = mvc.perform(get("/customers")).andDo(print());
		result.andExpect(status().isOk()).andExpect(jsonPath("$[0].name").exists());
	}
	
	@Test
	void testCalculateRewards() throws Exception {
		ResultActions result = mvc.perform(get("/customers/250/rewards")).andDo(print());
		result.andExpect(status().isOk()).andExpect(jsonPath("$.name",is("John"))).andExpect(jsonPath("$.totalRewards",is(625)));
		
	}

}
