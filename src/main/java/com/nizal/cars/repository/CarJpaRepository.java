package com.nizal.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nizal.cars.dto.CarDTO;

public interface CarJpaRepository extends JpaRepository<CarDTO, Long> {

	CarDTO findByBrand(String brand);
}
