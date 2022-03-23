package com.ers.ExpenseManagementSystemSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ers.ExpenseManagementSystemSpring.entity.ResolvedReimbursementEntity;

@Repository
public interface ResolvedReimbursementDao extends JpaRepository<ResolvedReimbursementEntity, Integer>{
	
}
