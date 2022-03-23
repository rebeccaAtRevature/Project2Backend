package com.ers.ExpenseManagementSystemSpring.service;

import java.util.List;

import com.ers.ExpenseManagementSystemSpring.pojo.ReimbursementPojo;

public interface ResolvedReimbursementService {

	// VIEW RESOLVED REIMBURSEMENT REQUESTS FOR LOGGED IN EMPLOYEE
	public List<ReimbursementPojo> viewResolvedRequests(int employeeId) ;
	
	// ADD TO RESOLVED REIMBURSEMENTS TABLE
	public ReimbursementPojo addResolvedRequest(ReimbursementPojo reimbursementPojo) ;
		
	// APPROVE OR DENY PENDING REIMBURSEMENT REQUESTS
	public ReimbursementPojo approveOrDeny(ReimbursementPojo reimbursementPojo) ;
	
	// READ ALL VALUES FROM RESOLVED REQUESTS TABLE
	public List<ReimbursementPojo> viewAllResolvedRequests() ;
	
	// READ ALL PENDING AND RESOLVED REIMBURSEMENTS FOR ANY SINGLE EMPLOYEE
	public List<ReimbursementPojo> viewAllRequests(int employeeId) ;
	
}
