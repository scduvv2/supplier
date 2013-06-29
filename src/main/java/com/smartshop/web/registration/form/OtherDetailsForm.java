package com.smartshop.web.registration.form;

import com.smartshop.store.Store;
import com.smartshop.web.account.Address;
import com.smartshop.web.account.PhoneNumber;

public class OtherDetailsForm {
	
	private Address address;
	
	private Store store;
	
	private PhoneNumber phoneNumber;
	
	public Address getAddress() {
		return address;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}


}
