package com.smartshop.web.account.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.smartshop.store.Catalog;


@Repository
public interface CatalogRepository extends MongoRepository<Catalog, String>{
	
	public Catalog findById(String catalogId);

}