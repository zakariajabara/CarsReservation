package com.nizal.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nizal.cars.dto.CustomerDTO;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerDTO, Long> {
	CustomerDTO findByName(String name);
	
}
