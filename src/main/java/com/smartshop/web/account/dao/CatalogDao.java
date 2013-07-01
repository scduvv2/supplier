package com.smartshop.web.account.dao;

import com.smartshop.store.Catalog;
import com.smartshop.store.Product;
import com.smartshop.store.Store;
import com.smartshop.web.account.Account;

public class CatalogDao extends BaseMongoDao {

	public Catalog findById(String catalogId) {
		
		
		return catalogRepository.findById(catalogId);
	}

	public Catalog findStoreById(String storeId) {
		
		Catalog catalog = null;
		Store store = storeRepository.findById(storeId);
		if(store!=null){
			catalog = store.getCatalog();
		}
		return catalog;
	}

	public void saveProduct(Product product, String catalogId) {
		productRepository.save(product);
		Catalog catalog = catalogRepository.findById(catalogId);
		catalog.addProduct(product);
		catalogRepository.save(catalog);
		
		
	}
	

}
