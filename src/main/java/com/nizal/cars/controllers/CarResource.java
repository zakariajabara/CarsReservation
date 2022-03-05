package com.nizal.cars.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nizal.cars.domain.Car;
import com.nizal.cars.service.CarService;

@RestController
@RequestMapping("/car")
public class CarResource {

	private final CarService carService;
	
	@Autowired
	public CarResource(CarService carService) {
		this.carService= carService;
	}
	
	@GetMapping
	public ResponseEntity<List<Car>> getAllCars(){
		List<Car> cars = carService.getAllCar();
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getCar(@PathVariable ("id") Long id){
		Car car = carService.findCarById(id);
		return new ResponseEntity<Car>(car, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Car> addCar(@RequestBody Car car) {
		Car newCar = carService.addCar(car);
		return new ResponseEntity<Car>(newCar, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Car> updateCar(@RequestBody Car car) {
		Car updatedCar = carService.updateCar(car);
		return new ResponseEntity<Car>(updatedCar, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable ("id") Long id){
		carService.deleteCar(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
}
