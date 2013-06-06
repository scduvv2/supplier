package com.smartshop.web.account;

public enum Role {
	merchant("merchant"),
	shopper("shopper");
	private String name;

	public String getName() {
		return name;
	}

	private Role(String name){
		this.name=name;
	}
	

}
