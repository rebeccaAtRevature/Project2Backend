package com.ers.ExpenseManagementSystemSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ers.ExpenseManagementSystemSpring.entity.ManagerEntity;

@Repository
public interface ManagerDao extends JpaRepository<ManagerEntity, Integer> {
	
}
