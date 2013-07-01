package com.smartshop.web.account.dao;

import com.smartshop.store.Catalog;
import com.smartshop.store.Store;
import com.smartshop.web.account.Account;

public class StoreDao extends BaseMongoDao {

	public Catalog findById(String catalogId) {
		
		
		return catalogRepository.findById(catalogId);
	}

	public Store findbyId(String storeId) {
	
		return storeRepository.findById(storeId);
	}
	

}
