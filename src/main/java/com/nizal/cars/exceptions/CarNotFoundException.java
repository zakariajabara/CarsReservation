package com.nizal.cars.exceptions;

public class CarNotFoundException extends RuntimeException{
	private String message;
   public CarNotFoundException(String message) {
	   this.message = message;
   }
	
}
