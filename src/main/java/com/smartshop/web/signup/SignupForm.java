package com.smartshop.web.signup;



import com.smartshop.web.account.Account;
import com.smartshop.web.account.Role;

public class SignupForm {

	private static final String NOT_BLANK_MESSAGE = "{notBlank.message}";
	private static final String EMAIL_MESSAGE = "{email.message}";


	private String name;

	private String email;

	private String password;
	
	private Role role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Account createAccount() {
		Account account = new Account(getEmail(), getPassword(), getName(), Role.merchant);
		
		return account;
	}
}
