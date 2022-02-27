package com.nizal.cars.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nizal.cars.dto.CustomerDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
	
	@Autowired
	private MockMvc mvc;

	//
	private JacksonTester<CustomerDTO> json;
	
	
	@Before
	public void setup() {
		JacksonTester.initFields(this,  new ObjectMapper());
	}
	
	@Test
	void test() throws Exception{
		MockHttpServletResponse response = mvc.perform(get("/api/customer/").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}

}
