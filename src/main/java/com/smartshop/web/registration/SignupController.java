package com.smartshop.web.registration;

import javax.validation.Valid;

import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import com.smartshop.web.account.*;
import com.smartshop.web.account.dao.AccountDetailsDao;
import com.smartshop.web.account.repository.AccountRepository;
import com.smartshop.web.registration.form.SignupForm;
import com.smartshop.web.security.UserService;

@Controller
public class SignupController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AccountDetailsDao accountDetailsDao;

	@RequestMapping(value = "signup")
	public SignupForm signup() {
		return new SignupForm();
	}

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors) {

		BaseDocument previousAccount = accountDetailsDao.findAccountByEmail(signupForm.getEmail());
		if(previousAccount!=null){
			errors.reject("1234", "user exists");
		}
		if (errors.hasErrors()) {
			return null;
		}

		Account account = accountDetailsDao.createAccount(signupForm);
		userService.signin(account);
		return "redirect:/";
	}


	
}
