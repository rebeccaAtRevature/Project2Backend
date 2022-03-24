package com.ers.ExpenseManagementSystemSpring.service;

import com.ers.ExpenseManagementSystemSpring.pojo.ManagerPojo;


public interface ManagerService {
	
	// LOGIN
	public ManagerPojo managerLogin(int managerId, String managerPassword);
	
	// READ FROM MANAGER DETAILS TABLE
	public ManagerPojo fetchManager(int managerId);

}
