package com.nizal.cars.controller;

import java.util.List;
import java.util.Optional;

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

import com.nizal.cars.dto.CustomerDTO;
import com.nizal.cars.repository.CustomerJpaRepository;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	private CustomerJpaRepository customerJpaRepository;
	
	@Autowired
	public void setCustomerJpaRepository(CustomerJpaRepository customerJpaRepository) {
		this.customerJpaRepository = customerJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CustomerDTO>> listAllCustomers() {
		//List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		List<CustomerDTO> customers = customerJpaRepository.findAll();
		return new ResponseEntity<List<CustomerDTO>>(customers, HttpStatus.OK);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> createUser(@RequestBody final CustomerDTO user) {
	  customerJpaRepository.save(user);
	  return new ResponseEntity<CustomerDTO>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerbyID(@PathVariable("id") final Long id) {
		CustomerDTO customer = (customerJpaRepository.findById(id)).get();
		return new ResponseEntity<CustomerDTO> (customer, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") final Long id,@RequestBody CustomerDTO customer ) {
		System.out.println("UPDATE CUSTOMER");
		CustomerDTO currentCustomer = customerJpaRepository.findById(id).get();
		currentCustomer.setCountry(customer.getCountry());
		currentCustomer.setName(customer.getName());
		currentCustomer.setTel(customer.getTel());
		System.out.println(currentCustomer);
		customerJpaRepository.saveAndFlush(currentCustomer);
		return new ResponseEntity<CustomerDTO>(currentCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("id") final Long id){
		customerJpaRepository.deleteById(id);
		return new ResponseEntity<CustomerDTO>(HttpStatus.NO_CONTENT);
		
	}
	
}
