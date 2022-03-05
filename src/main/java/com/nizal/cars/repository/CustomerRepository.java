package com.nizal.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nizal.cars.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
