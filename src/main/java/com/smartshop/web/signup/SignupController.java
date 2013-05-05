package com.smartshop.web.signup;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.smartshop.web.account.*;
import com.smartshop.web.account.repository.AccountRepository;

@Controller
public class SignupController {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "signup")
	public SignupForm signup() {
		return new SignupForm();
	}



	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors) {

		Account previousAccount = accountRepository.findByEmail(signupForm.getEmail());
		if(previousAccount!=null){
			errors.reject("1234", "user exists");
		}
		if (errors.hasErrors()) {
			return null;
		}

		Account account = accountRepository.save(createAccount(signupForm));
		userService.signin(account);
		return "redirect:/";
	}


	public Account createAccount(SignupForm signupForm) {


		Account account = new Account(signupForm.getEmail(), passwordEncoder.encodePassword(signupForm.getPassword(), null), signupForm.getFirstName(),signupForm.getLastName());
		if(signupForm.isSeller()){
			account.addRole(Role.merchant);
		}
		return account;
	}
}
