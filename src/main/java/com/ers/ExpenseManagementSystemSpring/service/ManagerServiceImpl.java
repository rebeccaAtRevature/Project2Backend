package com.ers.ExpenseManagementSystemSpring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ers.ExpenseManagementSystemSpring.dao.ManagerDao;
import com.ers.ExpenseManagementSystemSpring.entity.EmployeeEntity;
import com.ers.ExpenseManagementSystemSpring.entity.ManagerEntity;
import com.ers.ExpenseManagementSystemSpring.pojo.EmployeePojo;
import com.ers.ExpenseManagementSystemSpring.pojo.ManagerPojo;

import exceptions.SystemException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ManagerServiceImpl implements ManagerService {
	
	@Autowired
	ManagerDao managerDao;
	
	public ManagerPojo managerLogin(int managerId, String managerPassword) {
		log.info("Entering managerLogin() in Service Layer");
		
		ManagerPojo managerPojo = null;
		ManagerPojo loginAttempt = fetchManager(managerId);
		if (loginAttempt.getManagerPassword().equals(managerPassword)) {
			managerPojo = loginAttempt;
		}
		log.info("Exiting managerLogin() in Service Layer");
		return managerPojo;
	}

	@Override
	public ManagerPojo fetchManager(int managerId) {
		log.info("Entering fetchManager() in Service Layer");
		Optional<ManagerEntity> optional = managerDao.findById(managerId);
		ManagerPojo managerPojo = null;
		if (optional.isPresent()) {
			ManagerEntity managerEntity = optional.get();
			managerPojo = new ManagerPojo(managerEntity.getManagerId(), managerEntity.getManagerFirstName(),managerEntity.getManagerLastName(),managerEntity.getManagerPhoneNumber(),managerEntity.getManagerAddress(),managerEntity.getManagerPassword(),managerEntity.getManagerImageUrl());
		}
		log.info("Exiting fetchManager() in Service Layer");
		return managerPojo;
	}
	
}
