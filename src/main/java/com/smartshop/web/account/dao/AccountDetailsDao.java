package com.smartshop.web.account.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import com.smartshop.web.account.Account;
import com.smartshop.web.account.Role;
import com.smartshop.web.account.Store;
import com.smartshop.web.account.repository.AccountRepository;
import com.smartshop.web.account.repository.AddressRepository;
import com.smartshop.web.account.repository.PhoneNumberRepository;
import com.smartshop.web.account.repository.StoreRepository;
import com.smartshop.web.signup.OtherDetailsForm;
import com.smartshop.web.signup.ProfileForm;
import com.smartshop.web.signup.SignupForm;


public class AccountDetailsDao {
	
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	PhoneNumberRepository phoneNumberRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public Account findAccountByEmail(String email){
		
		return accountRepository.findByEmail(email);
		
	}
	
	public Account createAccount(SignupForm signupForm) {

		Account account = findAccountByEmail(signupForm.getEmail());
		if(account==null){
			account= new Account(signupForm.getEmail(), passwordEncoder.encodePassword(signupForm.getPassword(), null), signupForm.getFirstName(),signupForm.getLastName());
			if(signupForm.isSeller()){
				account.addRole(Role.merchant);
			}
			accountRepository.save(account);	
		}
		return account;
	}

	public boolean areAccountDetailsAdded(String email) {
		
		Account account = findAccountByEmail(email);
		
		return account.getPhoneNumber()!=null||account.getAddress()!=null;
	}

	public void addOtherDetails(OtherDetailsForm otherDetailsForm,
			String email) {
		Account account  = findAccountByEmail(email);
		if(account!=null && !areAccountDetailsAdded(email)){
			
			addressRepository.save(otherDetailsForm.getAddress());
			phoneNumberRepository.save(otherDetailsForm.getPhoneNumber());
			saveStore(otherDetailsForm.getStore());
			account.setAddress(otherDetailsForm.getAddress());
			account.setPhoneNumber(otherDetailsForm.getPhoneNumber());
			account.setStore(otherDetailsForm.getStore());
			accountRepository.save(account);
			
		}
	}

	public Store saveStore(Store store) {
	
		
		return store;
		
	}

	public void updateDetails(ProfileForm profileForm, String email) {
		Account account  = findAccountByEmail(email);
		if(profileForm.getAddress()!=null && !profileForm.getAddress().equals(account.getAddress())){
			addressRepository.save(profileForm.getAddress());
			account.setAddress(profileForm.getAddress());
			
		}
		if(profileForm.getPhoneNumber()!=null && !profileForm.getPhoneNumber().equals(account.getPhoneNumber())){
			phoneNumberRepository.save(profileForm.getPhoneNumber());
			account.setPhoneNumber(profileForm.getPhoneNumber());
			
		}
		
		if(profileForm.getStore()!=null && !profileForm.getStore().equals(account.getStore())){
			storeRepository.save(profileForm.getStore());
			account.setStore(profileForm.getStore());
			
		}
		accountRepository.save(account);
	}

}
