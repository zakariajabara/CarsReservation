package com.nizal.cars.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nizal.cars.dto.CarDTO;
import com.nizal.cars.dto.CustomerDTO;

@RestController
@RequestMapping("/api/car/")
public class CarController {
	
	@GetMapping("/")
	public ResponseEntity<List<CarDTO>> listAllCars() {
		List<CarDTO> cars = new ArrayList<CarDTO>();
		return new ResponseEntity<List<CarDTO>>(cars, HttpStatus.OK);
	}

}
