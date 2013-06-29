package com.smartshop.web.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartshop.store.Product;
import com.smartshop.store.Store;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
	
	public Product findByName(String name);

}
