package com.smartshop.web.account;

import org.springframework.data.annotation.Id;

public class BaseDocument {

	@Id
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	@Override
	public boolean equals(Object obj) {
	
		return this.toString().equalsIgnoreCase(obj.toString());
	}

}