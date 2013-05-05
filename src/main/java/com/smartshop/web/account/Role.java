package com.smartshop.web.account;

public enum Role {
	merchant("seller"),
	shopper("shopper");
	public static final String SELLER="seller";
	public static final String SHOPPER="shopper";
	private String name;

	public String getName() {
		return name;
	}

	private Role(String name){
		this.name=name;
	}
	

}
