package com.nizal.cars.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;



@Entity
@Table(name = "Cars")
public class CarDTO {
	
	@Id
	@GeneratedValue
	@Column(name="CAR_ID")
	private Long id;
	
	@Length(max = 15, min = 2)	
	@Column(name="BRAND")
	private String brand;
	
	@Length(min=2, max=20)
	@Column(name="MODELL")
	private String modell;
	
	@Length(min=2, max=10)
	@Column(name="LICENCE_NUMBER")
	private String licenceNumber;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}
	public String getLicenceNumber() {
		return licenceNumber;
	}
	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}
}
