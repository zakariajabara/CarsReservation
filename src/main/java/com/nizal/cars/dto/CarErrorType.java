package com.nizal.cars.dto;

public class CarErrorType extends CarDTO {

	private String errorMessage;
	
	public CarErrorType(String errorMessage) {
		this.errorMessage = errorMessage;
		
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}
	
}
