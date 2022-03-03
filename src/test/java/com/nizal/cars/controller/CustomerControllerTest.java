package com.nizal.cars.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nizal.cars.dto.CustomerDTO;
import com.nizal.cars.repository.CustomerJpaRepository;

@WebMvcTest(CustomerController.class)
@RunWith(SpringRunner.class)
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private CustomerJpaRepository customerJpaRepository;
	//
	private JacksonTester<CustomerDTO> json;
	
	private JacksonTester<CustomerDTO> jsonResult;
	private CustomerDTO testCustomer;
	
	
	@Before
	public void setup() {
		JacksonTester.initFields(this,  new ObjectMapper());
	}
	
	private CustomerDTO createCustomer(long id) {
		CustomerDTO customer=  new CustomerDTO();
		customer.setId(id);
		customer.setName("TestPersoN");
		customer.setCountry("NoCountry");
		customer.setTel("1234");
		return customer;
	}

	@Test
	public void testGetMappingWithNoContent() throws Exception{
		MockHttpServletResponse response = mvc.perform(get("/api/customer/").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.NO_CONTENT.value());
	}
		
	@Test
	public void testPostRequest() throws Exception{
		testCustomer= createCustomer(1L);
		// When
		MockHttpServletResponse response = mvc.perform(
		                post("/api/customer/").contentType(MediaType.APPLICATION_JSON)
		                        .content(jsonResult.write(testCustomer).getJson()))
		                .andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
	}

	@Test
	public void testGetMappingWithContent() throws Exception{
		testCustomer = createCustomer(2L);
		MockHttpServletResponse  response = mvc.perform(
                post("/api/customer/").contentType(MediaType.APPLICATION_JSON)
                        .content(jsonResult.write(testCustomer).getJson()))
                .andReturn().getResponse();
		response = mvc.perform(get("/api/customer/").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		//assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.name());
	}

}
