package com.smartshop.web.signup;

import java.io.IOException;
import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartshop.web.account.Account;
import com.smartshop.web.account.dao.AccountDetailsDao;

@Controller
public class ProfileController {
	

	@Autowired
	private AccountDetailsDao accountDetailsDao;
	
	
	@RequestMapping(value = "profile")
	public ProfileForm formPreProcess(UserDetails userDetails) throws IOException {
		
		Account account = accountDetailsDao.findAccountByEmail(userDetails.getUsername());
		
		ProfileForm profileForm = new ProfileForm();
		profileForm.setFirstName(account.getFirstName());
		profileForm.setLastName(profileForm.getLastName());
		profileForm.setAddress(account.getAddress());
		profileForm.setPhoneNumber(account.getPhoneNumber());
		profileForm.setStore(account.getStore());
		profileForm.setEmail(account.getEmail());
		profileForm.setStore(account.getStore());

		return profileForm;
	}
	
	@RequestMapping(value="profile",method=RequestMethod.POST)
	public String updateProfile(@Valid @ModelAttribute ProfileForm profileForm, Errors errors, UserDetails userDetails){
		
		
		accountDetailsDao.updateDetails(profileForm,userDetails.getUsername());
		return "redirect:/dashboard";
		
	}


}
