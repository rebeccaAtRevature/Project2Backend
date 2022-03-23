package com.ers.ExpenseManagementSystemSpring.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ers.ExpenseManagementSystemSpring.entity.ResolvedReimbursementEntity;
import com.ers.ExpenseManagementSystemSpring.pojo.ReimbursementPojo;

@Repository
public interface ResolvedReimbursementDao extends JpaRepository<ResolvedReimbursementEntity, Integer>{
	
	// VIEW RESOLVED REIMBURSEMENT REQUESTS FOR LOGGED IN EMPLOYEE
	@Query("SELECT reimbursement_details.reimbursement_id, resolved_reimbursement_id, requesting_employee_id, reimbursement_amount, reimbursement_pending, request_approved, date_of_request, date_resolved "
			+ "FROM reimbursement_details "
			+ "INNER JOIN resolved_reimbursements "
			+ "ON reimbursement_details.reimbursement_id=resolved_reimbursements.reimbursement_id "
			+ "WHERE requesting_employee_id=:employeeId "
			+ "ORDER BY resolved_reimbursements.date_resolved")
	public List<ReimbursementPojo> viewResolvedRequests(@Param("employeeId") int employeeId);
	
	// READ ALL VALUES FROM RESOLVED REQUESTS TABLE
	@Query("SELECT reimbursement_details.reimbursement_id, resolved_reimbursement_id, requesting_employee_id, reimbursement_amount, reimbursement_pending, request_approved, date_of_request, date_resolved "
			+ "FROM reimbursement_details "
			+ "INNER JOIN resolved_reimbursements "
			+ "ON reimbursement_details.reimbursement_id=resolved_reimbursements.reimbursement_id "
			+ "ORDER BY resolved_reimbursements.date_resolved")
	public List<ReimbursementPojo> viewAllResolvedRequests();
	
	// READ ALL PENDING AND RESOLVED REIMBURSEMENTS FOR ANY SINGLE EMPLOYEE
	@Query("SELECT resolved_reimbursement_id, reimbursement_details.reimbursement_id, requesting_employee_id, reimbursement_amount, reimbursement_pending, request_approved, date_of_request, date_resolved "
			+ "FROM reimbursement_details "
			+ "LEFT JOIN resolved_reimbursements "
			+ "ON reimbursement_details.reimbursement_id=resolved_reimbursements.reimbursement_id "
			+ "WHERE requesting_employee_id=:employeeId "
			+ "ORDER BY reimbursement_details.reimbursement_id")
	public List<ReimbursementPojo> viewAllRequests(@Param("employeeId") int employeeId);
}
