package com.ers.ExpenseManagementSystemSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ers.ExpenseManagementSystemSpring.dao.EmployeeDao;
import com.ers.ExpenseManagementSystemSpring.entity.EmployeeEntity;
import com.ers.ExpenseManagementSystemSpring.pojo.EmployeePojo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	// LOGIN
	public EmployeePojo employeeLogin(int employeeId, String employeePassword) {
		log.info("Entering employeeLogin() in Service Layer");

		EmployeePojo employeePojo = null;
		EmployeePojo loginAttempt = fetchEmployee(employeeId);
		if (loginAttempt.getEmployeePassword().equals(employeePassword)) {
			employeePojo = loginAttempt;
		}
		log.info("Exiting employeeLogin() in Service Layer");
		return employeePojo;
	}
	// READ FROM EMPLOYEE DETAILS TABLE
	public EmployeePojo fetchEmployee(int employeeId) {
		log.info("Entering fetchEmployee() in Service Layer");
		Optional <EmployeeEntity> optional = employeeDao.findById(employeeId);
		EmployeePojo employeePojo = null;
		if (optional.isPresent()) {
			EmployeeEntity employeeEntity = optional.get();
			employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(),employeeEntity.getEmployeeFirstName(),employeeEntity.getEmployeeLastName(),employeeEntity.getEmployeePhoneNumber(),employeeEntity.getEmployeeAddress(),employeeEntity.getEmployeePassword(),employeeEntity.getEmployeeImageUrl());
		}
		log.info("Exiting fetchEmployee() in Service Layer");
		return employeePojo;
	}
	// UPDATE EMPLOYEE DETAILS TABLE
	public EmployeePojo updateEmployee(EmployeePojo employeePojo) {
		log.info("Entering updateEmployee() in Service Layer");
		EmployeeEntity employeeEntity = new EmployeeEntity(employeePojo.getEmployeeId(),employeePojo.getEmployeeFirstName(),employeePojo.getEmployeeLastName(),employeePojo.getEmployeePhoneNumber(),employeePojo.getEmployeeAddress(),employeePojo.getEmployeePassword(),employeePojo.getEmployeeImageUrl());
		employeeDao.save(employeeEntity);		
		employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(),employeeEntity.getEmployeeFirstName(),employeeEntity.getEmployeeLastName(),employeeEntity.getEmployeePhoneNumber(),employeeEntity.getEmployeeAddress(),employeeEntity.getEmployeePassword(),employeeEntity.getEmployeeImageUrl());
		log.info("Exiting updateEmployee() in Service Layer");
		return employeePojo;
	}	
	// VIEW ALL EMPLOYEES
	public List<EmployeePojo> viewAllEmployees() {
		log.info("Entering viewAllEmployees() in Service Layer");
		List<EmployeePojo> allEmployeePojo = new ArrayList<EmployeePojo>();
		List<EmployeeEntity> allEmployeeEntity = employeeDao.findAll();
		allEmployeeEntity.forEach((employeeEntity) -> {
			EmployeePojo employeePojo = new EmployeePojo(employeeEntity.getEmployeeId(),employeeEntity.getEmployeeFirstName(),employeeEntity.getEmployeeLastName(),employeeEntity.getEmployeePhoneNumber(),employeeEntity.getEmployeeAddress(),employeeEntity.getEmployeePassword(),employeeEntity.getEmployeeImageUrl());
			allEmployeePojo.add(employeePojo);
		});
		log.info("Exiting viewAllEmployees() in Service Layer");
		return allEmployeePojo;
	}
}
