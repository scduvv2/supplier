package com.smartshop.web.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartshop.store.Category;


@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
	
	

}
