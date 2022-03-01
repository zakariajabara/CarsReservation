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
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nizal.cars.dto.CarDTO;
import com.nizal.cars.repository.CarJpaRepository;

@WebMvcTest(CarController.class)
@RunWith(SpringRunner.class)
public class CarControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	CarJpaRepository carJpaRepository;
	
	private JacksonTester<CarDTO> jsonResult;
	private JacksonTester<CarDTO> jsonReponse;
	
	private JacksonTester<CarDTO> json;
	
	@Before
	public void setUp() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	
	void generateTestWithParameter(final boolean correct) throws Exception{
		CarDTO car = new CarDTO();
		car.setBrand("MERCEDES");
		car.setModell("GLC");
		car.setLicenceNumber("EU-1111");

		// When
		MockHttpServletResponse response = mvc.perform(
		                post("/api/car/").contentType(MediaType.APPLICATION_JSON)
		                        .content(jsonResult.write(car).getJson()))
		                .andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED.value());
		assertThat(response.getContentAsString()).isEqualTo(jsonReponse.write(car).getJson());
	}
	
	@Test
	public void testPostRequest() throws Exception{
		generateTestWithParameter(true);
	}
	
	@Test
	public void testGetRequest() throws Exception{
		MockHttpServletResponse response = mvc.perform(get("/api/car/").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
	}
	
	

}
