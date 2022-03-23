package com.ers.ExpenseManagementSystemSpring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ers.ExpenseManagementSystemSpring.entity.ReimbursementEntity;

@Repository
public interface ReimbursementDao extends JpaRepository<ReimbursementEntity, Integer> {
	
	// VIEW PENDING REIMBUSEMENT REQUEST FOR LOGGED IN EMPLOYEE
	@Query("SELECT * FROM reimbursement_details WHERE requesting_employee_id= :employeeId AND reimbursement_pending='t'")
	public List<ReimbursementEntity> viewPendingRequests(@Param("employeeId") int employeeId);
	
	// READ ALL VALUES FROM PENDING REQUESTS TABLE
	@Query("SELECT * FROM reimbursement_details WHERE reimbursement_pending='t'")
	public List<ReimbursementEntity> viewAllPendingRequests();
	
}
