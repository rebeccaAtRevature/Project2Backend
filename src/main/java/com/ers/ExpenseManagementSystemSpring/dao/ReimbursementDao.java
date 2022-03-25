package com.ers.ExpenseManagementSystemSpring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ers.ExpenseManagementSystemSpring.entity.ReimbursementEntity;

@Repository
public interface ReimbursementDao extends JpaRepository<ReimbursementEntity, Integer> {
	
	// VIEW PENDING REIMBUSEMENT REQUEST FOR LOGGED IN EMPLOYEE
	@Query("FROM ReimbursementEntity r WHERE r.employeeEntity.employeeId=:employeeId AND r.reimbursementPending='t'")
	public List<ReimbursementEntity> viewPendingRequests(@Param("employeeId") int employeeId);

	// VIEW ALL PENDING REQUESTS OR ALL RESOLVED REQUESTS
	public List<ReimbursementEntity> findByReimbursementPending(boolean reimbursementPending);
	
	// VIEW ALL PENDING REQUESTS AND RESOLVED REQUESTS FOR A SINGLE EMPLOYEE
	@Query("FROM ReimbursementEntity r WHERE r.employeeEntity.employeeId=:employeeId")
	public List<ReimbursementEntity> findByEmployeeId(@Param("employeeId") int employeeId);

}
