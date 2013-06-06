package com.smartshop.web.account;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address extends BaseDocument{
	
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String zipCode;
	

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;   
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getCountry() {
		return country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	@Override
	public String toString() {
		return this.addressLine1.trim()+this.city.trim()+this.zipCode.trim();
	}

}
