package com.smartshop.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.smartshop.web.account.BaseDocument;

@Document
public class Product extends BaseDocument {
	
	private String name;
	private String brand;
	private Long productId;
	private List<Category> categories;
	
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public Long getProductId() {
		return productId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategory(Category category){
		if(this.categories==null){
			this.categories = new ArrayList<Category>();
		}
		this.categories.add(category);
	}
	
	

}
