package com.ers.ExpenseManagementSystemSpring.service;

import java.util.List;

import com.ers.ExpenseManagementSystemSpring.pojo.EmployeePojo;

import exceptions.SystemException;

public interface EmployeeService {
	
	// LOGIN
	public EmployeePojo employeeLogin(int employeeId, String employeePassword);
	
	// READ FROM EMPLOYEE DETAILS TABLE
	public EmployeePojo fetchEmployee(int employeeId);
	
	// UPDATE EMPLOYEE DETAILS TABLE
	public EmployeePojo updateEmployee(EmployeePojo employeePojo);
	
	// VIEW ALL EMPLOYEES
	public List<EmployeePojo> viewAllEmployees();
}
