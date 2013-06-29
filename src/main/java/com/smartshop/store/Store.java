package com.smartshop.store;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.smartshop.web.account.Account;
import com.smartshop.web.account.Address;
import com.smartshop.web.account.BaseDocument;
import com.smartshop.web.account.PhoneNumber;

@Document
public class Store extends BaseDocument{
	
	private String name;
	
	
	@DBRef
	private Address address;

	
	@DBRef
	private PhoneNumber phoneNumber;
	
	@DBRef
	private Catalog catalog;

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Catalog getCatalog() {
		return catalog;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	@Override
	public String toString() {
		
		return name.trim();
	}

}
