package com.smartshop.supplier.web;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartshop.store.Catalog;
import com.smartshop.store.Product;
import com.smartshop.store.Store;
import com.smartshop.supplier.web.form.AddProductForm;
import com.smartshop.supplier.web.model.CatalogPage;
import com.smartshop.web.account.Account;
import com.smartshop.web.account.dao.AccountDetailsDao;
import com.smartshop.web.account.dao.CatalogDao;
import com.smartshop.web.account.dao.StoreDao;
import com.smartshop.web.registration.form.OtherDetailsForm;



@Controller
public class StoreController {

	@Autowired
	CatalogDao catalogDao;

	@Autowired
	StoreDao storeDao; 

	@Autowired
	AccountDetailsDao accountDetailsDao;

	@RequestMapping(value = "/store/{storeId}/overview/",method=RequestMethod.GET)
	public CatalogPage getCatalog(@PathVariable("storeId") String storeId,UserDetails userDetails,HttpServletResponse response) throws IOException {

		CatalogPage catalogPage = new CatalogPage();
		Account account = accountDetailsDao.findAccountByEmail(userDetails.getUsername());
		Store store = storeDao.findbyId(storeId);
		catalogPage.setAccount(account);
		catalogPage.setStore(store);
		return catalogPage;

	}
}