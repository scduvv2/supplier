package com.smartshop.supplier.web;

public class BaseException extends Exception {

	String errorCode;
	
	public BaseException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
