package com.nizal.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nizal.cars.dto.CarDTO;

@Repository
public interface CarJpaRepository extends JpaRepository<CarDTO, Long> {

	CarDTO findByBrand(String brand);
	CarDTO findByLicenceNumber(String licenceNumber);
}
