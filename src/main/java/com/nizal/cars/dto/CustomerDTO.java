package com.nizal.cars.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Customers")
public class CustomerDTO {

	@Id
    @GeneratedValue
	@Column(name = "USER_ID")
	private Long id;
	
	@Length(min=2, max=50, message="error.name.length")
	@Column(name = "NAME")
	private String name;

	@Length(min=2, max=20, message="error.country.length")
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "TEL")
	private String tel;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
}
