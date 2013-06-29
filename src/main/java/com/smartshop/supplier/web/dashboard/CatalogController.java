package com.smartshop.supplier.web.dashboard;



import java.io.IOException;
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
import com.smartshop.supplier.web.dashboard.form.AddProductsForm;
import com.smartshop.web.account.dao.AccountDetailsDao;
import com.smartshop.web.account.dao.CatalogDao;
import com.smartshop.web.registration.form.OtherDetailsForm;



@Controller
public class CatalogController {

	@Autowired
	CatalogDao catalogDao;

	@RequestMapping(value = "/store/{storeId}/catalog",method=RequestMethod.GET)
	public Catalog getCatalog(@PathVariable("storeId") String storeId,UserDetails userDetails,HttpServletResponse response) throws IOException {
		
		return catalogDao.findStoreById(storeId);

	}



	@RequestMapping(value = "/catalog/{catalogId}/product",method=RequestMethod.POST)
	public Catalog addProducts(@PathVariable("catalogId") String catalogId,UserDetails userDetails,AddProductsForm addProductsForm,HttpServletResponse response) throws IOException {
		
		Catalog catalog = catalogDao.findById(catalogId);
		catalog.addProducts(addProductsForm.getProducts());	
		return catalog;
	}
}
