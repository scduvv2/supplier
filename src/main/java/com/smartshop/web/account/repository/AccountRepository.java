package com.smartshop.web.account.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.smartshop.web.account.Account;


public interface AccountRepository extends MongoRepository<Account, String> {
	
	public Account findByUsername(String username);
	
}
