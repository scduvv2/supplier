package com.smartshop.supplier.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartshop.web.account.Account;
import com.smartshop.web.account.dao.AccountDetailsDao;

@Controller class DashboardController {
	
	@Autowired
	private AccountDetailsDao accountDetailsDao;
	

	
	@RequestMapping(value = "dashboard" )
	public Account dashBoardOverView(UserDetails userDetails,HttpServletResponse response){
		
		
		Account account  = accountDetailsDao.findAccountByEmail(userDetails.getUsername());
		return account;
	}
	

}
