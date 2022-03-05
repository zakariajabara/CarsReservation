package com.nizal.cars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nizal.cars.repository.CustomerJpaRepository;

@Service
public class CustomerService {

	private CustomerJpaRepository customerJpaRepository;
	
	@Autowired
	public CustomerService(CustomerJpaRepository customerJpaRepository) {
		this.customerJpaRepository= customerJpaRepository;
	}
	
}
