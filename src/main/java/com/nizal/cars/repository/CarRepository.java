package com.nizal.cars.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nizal.cars.domain.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

	Optional<Car> findCarByLicenceNumber(String licenceNumber);
	List<Car> findCarByBrand(String brand);
	void deleteCarById(Long id);
}
