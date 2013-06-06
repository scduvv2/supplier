package com.smartshop.web.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartshop.web.account.Store;

@Repository
public interface StoreRepository extends MongoRepository<Store, String>{
	
	public Store findByName(String name);

}
