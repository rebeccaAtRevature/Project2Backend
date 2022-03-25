package com.ers.ExpenseManagementSystemSpring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ers.ExpenseManagementSystemSpring.entity.ResolvedReimbursementEntity;

@Repository
public interface ResolvedReimbursementDao extends JpaRepository<ResolvedReimbursementEntity, Integer>{
	// VIEW RESOLVED REIMBURSEMENT REQUESTS FOR LOGGED IN EMPLOYEE
	@Query("FROM ReimbursementEntity r WHERE r.employeeEntity.employeeId=:employeeId AND r.reimbursementPending='f'")
	public List<ResolvedReimbursementEntity> viewResolvedRequests(@Param("employeeId") int employeeId);
		
}
