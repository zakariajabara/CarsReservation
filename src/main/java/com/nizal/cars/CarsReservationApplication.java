package com.nizal.cars;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nizal.cars.dto.CustomerDTO;
import com.nizal.cars.repository.CustomerJpaRepository;

@SpringBootApplication
@RestController
public class CarsReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsReservationApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(CustomerJpaRepository userRepository) {
        return args -> {
        	//int i = 1;
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                CustomerDTO customer = new CustomerDTO();
                customer.setName(name);
                customer.setCountry("Qatar");
                customer.setTel( "23");
                //i++;
                userRepository.save(customer);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hi Everybody";
	}

}
