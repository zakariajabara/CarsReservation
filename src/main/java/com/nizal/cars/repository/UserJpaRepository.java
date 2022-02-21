package com.nizal.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nizal.cars.dto.CustomerDTO;

public interface UserJpaRepository extends JpaRepository<CustomerDTO, Long> {

	CustomerDTO findByName(String name);
}
