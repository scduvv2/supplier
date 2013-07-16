package com.smartshop.supplier.web;



import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.smartshop.store.Catalog;
import com.smartshop.store.Product;
import com.smartshop.store.Store;
import com.smartshop.supplier.web.form.AddMultipleProductsForm;
import com.smartshop.supplier.web.form.AddProductForm;
import com.smartshop.supplier.web.model.CatalogPage;
import com.smartshop.web.account.Account;
import com.smartshop.web.account.dao.AccountDetailsDao;
import com.smartshop.web.account.dao.CatalogDao;
import com.smartshop.web.account.dao.StoreDao;
import com.smartshop.web.registration.form.OtherDetailsForm;



@Controller
public class CatalogController {

	@Autowired
	CatalogDao catalogDao;

	@Autowired
	StoreDao storeDao; 

	@Autowired
	AccountDetailsDao accountDetailsDao;

	@RequestMapping(value = "/catalog/{catalogId}/product/",method=RequestMethod.POST)
	public String addProducts(@PathVariable("catalogId") String catalogId,UserDetails userDetails,@Valid @ModelAttribute AddProductForm addProductForm,HttpServletResponse response) throws IOException {

		
		catalogDao.saveProduct(addProductForm.getProduct(),catalogId);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(value = "/catalog/{catalogId}/product/",method=RequestMethod.GET)
	public AddProductForm renderAddProducts(@PathVariable("catalogId") String catalogId,UserDetails userDetails,HttpServletResponse response) throws IOException {

		
		return new AddProductForm();
	}
	
	@RequestMapping(value = "/catalog/{catalogId}/products/",method=RequestMethod.POST)
    public String uploadMultipleProducts(@PathVariable("catalogId") String catalogId,@ModelAttribute AddMultipleProductsForm addMultipleProductsForm,
            HttpServletResponse httpServletResponse) {
    	
		File file = addMultipleProductsForm.getFile();
				
		
    	return "redirect:/dashboard";
    }
	
	@RequestMapping(value = "/catalog/{catalogId}/products/",method=RequestMethod.GET)
    public AddMultipleProductsForm uploadMultipleProductsFormView(@PathVariable("catalogId") String catalogId,HttpServletResponse httpServletResponse) {
    	
    	return new AddMultipleProductsForm();
    }
}