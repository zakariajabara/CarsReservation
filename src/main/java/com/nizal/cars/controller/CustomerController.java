package com.nizal.cars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nizal.cars.dto.CustomerDTO;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {
	
	@GetMapping("/")
	public ResponseEntity<List<CustomerDTO>> listAllCustomers() {
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		return new ResponseEntity<List<CustomerDTO>>(customers, HttpStatus.OK);
	}

}
