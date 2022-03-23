package com.ers.ExpenseManagementSystemSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ers.ExpenseManagementSystemSpring.pojo.EmployeePojo;
import com.ers.ExpenseManagementSystemSpring.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	// LOGIN
    @GetMapping("Employees/{employeeId}/{employeePassword}")
    public EmployeePojo employeeLogin(@PathVariable("employeeId") int employeeId, @PathVariable("employeePassword") String employeePassword) {
        return employeeService.employeeLogin(employeeId, employeePassword);
    }
    // READ FROM EMPLOYEE DETAILS TABLE
    @GetMapping("employees/{employeeId}")
    public EmployeePojo fetchEmployee(@PathVariable("employeeId") int employeeId) {    
		return employeeService.fetchEmployee(employeeId);
	}
    // UPDATE EMPLOYEE DETAILS TABLE
    @PutMapping("employees")
    public EmployeePojo updateEmployee(@RequestBody EmployeePojo employeePojo) {
        return employeeService.updateEmployee(employeePojo);
    }
    // VIEW ALL EMPLOYEES
    @GetMapping("employees")
    public List<EmployeePojo> viewAllEmployees() {
		return employeeService.viewAllEmployees();
    }
    
}
