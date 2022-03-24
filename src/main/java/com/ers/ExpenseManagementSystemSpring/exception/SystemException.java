package com.ers.ExpenseManagementSystemSpring.exception;

@SuppressWarnings("serial")
public class SystemException extends Exception{

	@Override
	public String getMessage() {
		return "System Error! Please try again later.";
	}
	
}
