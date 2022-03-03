package com.nizal.cars.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.nizal.cars.dto.CustomerErrorType;
import com.nizal.cars.repository.CustomerJpaRepository;

@RestController
@RequestMapping("/api/customer/")
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
		if(customers.isEmpty()) {
			return new ResponseEntity<List<CustomerDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CustomerDTO>>(customers, HttpStatus.OK);
	}

	private boolean checkDuplicat(final CustomerDTO user) {
	
		CustomerDTO customer = customerJpaRepository.findByTel(user.getTel());
		System.out.println(user.getTel());
		if(customer != null) {
//			System.out.println(customer.getName());
//			if(customer.getCountry()== user.getCountry() && customer.getTel() == user.getTel()) {
//				System.out.println("same user");
				return true;
//			}
//			else
//				return false;
		}
		return false;
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> createUser(@Valid @RequestBody final CustomerDTO user) {
		if(checkDuplicat(user) ) 
			return new ResponseEntity<CustomerDTO>(new CustomerErrorType("Customer "+ user.getName() + " from " +
		user.getCountry()+ " and Phonenumber "+ user.getTel() + "already exist"), HttpStatus.CONFLICT);
	  customerJpaRepository.save(user);
	  return new ResponseEntity<CustomerDTO>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerbyID(@PathVariable("id") final Long id) {
		CustomerDTO customer = (customerJpaRepository.findById(id)).get();
		if(customer == null) {
			return new ResponseEntity<CustomerDTO>(new CustomerErrorType("Customer with id"+ 
		  id + " not found"), HttpStatus.NOT_FOUND);
					
		}
		return new ResponseEntity<CustomerDTO> (customer, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable("id") final Long id,@RequestBody CustomerDTO customer ) {
		
		if(!customerJpaRepository.findById(id).isPresent()) {
			return new ResponseEntity<CustomerDTO>(new CustomerErrorType("Customer with id "+ id + " Not Found"),HttpStatus.NOT_FOUND);
		}
		CustomerDTO currentCustomer = customerJpaRepository.findById(id).get();
		currentCustomer.setCountry(customer.getCountry());
		currentCustomer.setName(customer.getName());
		currentCustomer.setTel(customer.getTel());
		customerJpaRepository.saveAndFlush(currentCustomer);
		return new ResponseEntity<CustomerDTO>(currentCustomer, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("id") final Long id){
		if( !customerJpaRepository.findById(id).isPresent())
		{
			return new ResponseEntity<CustomerDTO>(new CustomerErrorType("No customer with id "+ id + " to delete"), HttpStatus.NOT_FOUND);
		}
		customerJpaRepository.deleteById(id);
		return new ResponseEntity<CustomerDTO>(HttpStatus.NO_CONTENT);
		
	}
	
}
