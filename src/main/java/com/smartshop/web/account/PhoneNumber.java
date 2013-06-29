package com.smartshop.web.account;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PhoneNumber extends BaseDocument{

	private Long phoneNumber;

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		 
		return Long.toString(this.phoneNumber);
	}
}
