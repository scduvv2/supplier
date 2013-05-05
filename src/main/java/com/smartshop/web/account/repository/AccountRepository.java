package com.smartshop.web.account.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartshop.web.account.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {
	
	public Account findByEmail(String email);
	
}
