package com.ers.ExpenseManagementSystemSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ers.ExpenseManagementSystemSpring.entity.EmployeeEntity;

@Repository
public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer>{
	
}
