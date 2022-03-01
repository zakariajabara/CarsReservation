package com.nizal.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nizal.cars.dto.CarDTO;
import com.nizal.cars.repository.CarJpaRepository;

@RestController
@RequestMapping("/api/car/")
public class CarController {
	
	private CarJpaRepository carJpaRepository;
	
	@Autowired
	public void setCarJpaRepository(CarJpaRepository carJpaRepository) {
		this.carJpaRepository= carJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CarDTO>> listAllCars() {
		//List<CarDTO> cars = new ArrayList<CarDTO>();
		List<CarDTO> cars = carJpaRepository.findAll();
		return new ResponseEntity<List<CarDTO>>(cars, HttpStatus.OK);
	}
	
	@PostMapping(value="/", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarDTO> createCar(@RequestBody final CarDTO car){
		System.out.println("Create Car");
		carJpaRepository.save(car);
		return new ResponseEntity<CarDTO>(car, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarDTO> findCarById(@PathVariable("id") final Long id ){
		CarDTO car = carJpaRepository.findById(id).get();
		return new ResponseEntity<CarDTO>(car, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarDTO> updateCar(@PathVariable("id") final Long id , @RequestBody CarDTO car ) {
		//fetch car based on id and set it the the curent Customer
		CarDTO currentCar = carJpaRepository.findById(id).get();
		currentCar.setBrand(car.getBrand());
		currentCar.setModell(car.getModell());
		currentCar.setLicenceNumber(car.getLicenceNumber());
		
		carJpaRepository.saveAndFlush(currentCar);
		
		return new ResponseEntity<CarDTO>(currentCar, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CarDTO> deleteCar(@PathVariable("id") final Long id){
		carJpaRepository.deleteById(id);
		return new ResponseEntity<CarDTO>(HttpStatus.NO_CONTENT);
	}
}
