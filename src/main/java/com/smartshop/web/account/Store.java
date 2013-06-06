package com.smartshop.web.account;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Store extends BaseDocument{
	
	private String name;
	
	
	@DBRef
	private Address address;
	
	@DBRef
	private Account ownerAccount;
	
	@DBRef
	private List<Account> otherAccounts;
	
	@DBRef
	private PhoneNumber phoneNumber;

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

	public Account getOwnerAccount() {
		return ownerAccount;
	}

	public List<Account> getOtherAccounts() {
		return otherAccounts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setOwnerAccount(Account ownerAccount) {
		this.ownerAccount = ownerAccount;
	}

	public void setOtherAccounts(List<Account> otherAccounts) {
		this.otherAccounts = otherAccounts;
	}
	
	@Override
	public String toString() {
		
		return name.trim();
	}

}
