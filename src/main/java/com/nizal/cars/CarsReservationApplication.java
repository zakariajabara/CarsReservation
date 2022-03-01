package com.nizal.cars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CarsReservationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsReservationApplication.class, args);
	}
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hi Everybody";
	}

}
