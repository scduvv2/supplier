package com.smartshop.web.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartshop.store.Store;

@Repository
public interface StoreRepository extends MongoRepository<Store, String>{
	
	public Store findByName(String name);

	public Store findById(String storeId);

}
