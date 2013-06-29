package com.smartshop.web.registration;



import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smartshop.web.account.dao.AccountDetailsDao;
import com.smartshop.web.registration.form.OtherDetailsForm;



@Controller
public class OtherDetailsController {
	
	@Autowired
	private AccountDetailsDao accountDetailsDao;
	
	@RequestMapping(value = "add-details",method=RequestMethod.GET)
	public OtherDetailsForm formPreProcess(UserDetails userDetails,HttpServletResponse response) throws IOException {
		if(accountDetailsDao.areAccountDetailsAdded(userDetails.getUsername())){
			response.sendRedirect("profile");
		}
		return new OtherDetailsForm();
	}
	
	@RequestMapping(value="add-details",method=RequestMethod.POST)
	public String otherDetails(@Valid @ModelAttribute OtherDetailsForm otherDetailsForm, Errors errors, UserDetails userDetails){
		
		if (errors.hasErrors()) {
			return null;
		}
		accountDetailsDao.addOtherDetails(otherDetailsForm,userDetails.getUsername());
		
			return "redirect:/dashboard";
	}

}
