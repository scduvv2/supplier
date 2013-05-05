package com.smartshop.web.signup;


public class SignupForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";


	private String firstName;
	
	private String lastName;

	private String email;

	private String password;
	
	private boolean seller;
	
	public boolean isSeller() {
		return seller;
	}

	public void setSeller(boolean isSeller) {
		this.seller = isSeller;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getFirstName() {
		// TODO Auto-generated method stub
		return null;
	}


}
