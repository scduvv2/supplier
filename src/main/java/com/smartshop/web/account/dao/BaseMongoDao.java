package com.smartshop.web.account.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import com.smartshop.web.account.repository.AccountRepository;
import com.smartshop.web.account.repository.AddressRepository;
import com.smartshop.web.account.repository.CatalogRepository;
import com.smartshop.web.account.repository.CategoryRepository;
import com.smartshop.web.account.repository.PhoneNumberRepository;
import com.smartshop.web.account.repository.ProductRepository;
import com.smartshop.web.account.repository.StoreRepository;

public class BaseMongoDao {

	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	PhoneNumberRepository phoneNumberRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CatalogRepository catalogRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	

}