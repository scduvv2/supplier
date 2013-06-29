package com.smartshop.web.account.dao;

import com.smartshop.store.Catalog;
import com.smartshop.store.Store;
import com.smartshop.web.account.Account;
import com.smartshop.web.account.Role;
import com.smartshop.web.registration.form.OtherDetailsForm;
import com.smartshop.web.registration.form.ProfileForm;
import com.smartshop.web.registration.form.SignupForm;


public class AccountDetailsDao extends BaseMongoDao {
	
	

	
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
			account.addStore(otherDetailsForm.getStore());
			accountRepository.save(account);
			
		}
	}

	public Store saveStore(Store store) {
	
		addressRepository.save(store.getAddress());
		Catalog catalog = new Catalog();
		catalogRepository.save(catalog);
		store.setCatalog(catalog);
		phoneNumberRepository.save(store.getPhoneNumber());
		storeRepository.save(store);
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
		
		if(profileForm.getStore()!=null && !account.hasStore(profileForm.getStore())){
			storeRepository.save(profileForm.getStore());
			account.addStore(profileForm.getStore());
			
		}
		accountRepository.save(account);
	}

}
