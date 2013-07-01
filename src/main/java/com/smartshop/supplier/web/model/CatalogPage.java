package com.smartshop.supplier.web.model;

import com.smartshop.store.Product;
import com.smartshop.store.Store;
import com.smartshop.supplier.web.form.AddProductForm;
import com.smartshop.web.account.Account;

public class CatalogPage {

	/**
	 * 
	 */
	private Account account;
	
	private Store store;
	
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Account getAccount() {
		return account;
	}

	public Store getStore() {
		return store;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	AddProductForm addProductForm;

	public AddProductForm getAddProductsForm() {
		return addProductForm;
	}

	public void setAddProductsForm(AddProductForm addProductForm) {
		this.addProductForm = addProductForm;
	}


}
