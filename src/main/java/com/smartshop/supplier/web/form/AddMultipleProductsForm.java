package com.smartshop.supplier.web.form;



import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class AddMultipleProductsForm {
	
	private String name;
	  private CommonsMultipartFile fileData;
	 
	  public String getName()
	  {
	    return name;
	  }
	 
	  public void setName(String name)
	  {
	    this.name = name;
	  }
	 
	  public CommonsMultipartFile getFileData()
	  {
	    return fileData;
	  }
	 
	  public void setFileData(CommonsMultipartFile fileData)
	  {
	    this.fileData = fileData;
	  }
}
