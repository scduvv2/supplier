package com.smartshop.web.account;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.smartshop.store.Store;

@Document
public class Account extends BaseDocument {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private PhoneNumber phoneNumber;
	private List<Role> roles;
	@DBRef
	private Address address;
	
	public List<Store> getStores() {
		return stores;
	}

	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	
	public void addStore(Store store){
		if(this.stores==null){
			this.stores = new ArrayList<Store>();
		}
		this.stores.add(store);
	}

	@DBRef
	private List<Store> stores;
	
	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Account(String email, String password, String firstName, String lastName) {
		this.email=email; 
		this.password=password;
		this.lastName=lastName;
		this.firstName=firstName;
		this.roles = new ArrayList<Role>();
		this.roles.add(Role.shopper);
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role){
		this.roles.add(role);
	}



	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean hasStore(Store store) {
		for(Store existingStore : stores){
			if(existingStore.equals(store)){
				return true;
			}
				
			
		}
		return false;
	}

}
