package com.smartshop.web.signup;

import com.smartshop.web.account.Address;
import com.smartshop.web.account.PhoneNumber;
import com.smartshop.web.account.Store;

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
