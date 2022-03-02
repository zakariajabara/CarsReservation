package com.nizal.cars.dto;

public class CustomerErrorType extends CustomerDTO {

	private String errorMessage;
	
	public CustomerErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
		
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
}
