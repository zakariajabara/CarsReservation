package com.nizal.cars.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nizal.cars.domain.Car;
import com.nizal.cars.exceptions.CarNotFoundException;
import com.nizal.cars.repository.CarRepository;

@Service
public class CarService {

	private CarRepository carRepository;
	
	@Autowired
	public CarService(CarRepository carRepository) {
		this.carRepository= carRepository; 
	}
	
	public Car addCar(Car car) {
		car.setCarCode(UUID.randomUUID().toString());
		carRepository.save(car);
		return car;
	}
	
	public Car getCarByID(long id) {
		return carRepository.findById(id).get();
	}
	
	public List<Car> getAllCar(){
		return carRepository.findAll();
	}
	
	public Car getCarByLicenceNumber(String licenceNumber) {
	   return carRepository.findCarByLicenceNumber(licenceNumber).orElseThrow(() -> new CarNotFoundException("Car with Licence number " + licenceNumber+ " not found"));
	}
	
	public List<Car> findCarsByBrand(String brand) {
		List<Car> cars = carRepository.findAll();
		//cars.stream().forEach(car => );
		return cars;
	}
	
	public Car updateCar(Car car) {
		carRepository.save(car);
		return car;
	}
	
	public void deleteCar(Long id) {
		carRepository.deleteCarById(id);
	}

	public Car findCarById(Long id) {
		return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("No Car with id "+ id + " found"));
	}
}
