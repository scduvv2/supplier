package com.smartshop.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.smartshop.web.account.BaseDocument;

@Document
public class Catalog extends BaseDocument {

	@DBRef
	List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product){
		if(this.products ==null){
			this.products = new ArrayList<Product>();
		}
		this.products.add(product);
		
	}

	public void addProducts(List<Product> products) {
		if(this.products ==null){
			this.products = new ArrayList<Product>();
		}
		this.products.addAll(products);
		
		
	}
}
