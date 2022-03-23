package com.ers.ExpenseManagementSystemSpring.service;

import java.util.List;

import com.ers.ExpenseManagementSystemSpring.pojo.ReimbursementPojo;

public interface ReimbursementService {
	// SUBMIT A REIMBURSEMENT REQUEST
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo);
	// UPDATE REIMBURSEMENTS TABLE
	public ReimbursementPojo updatePendingRequest(ReimbursementPojo reimbursementPojo);
	// VIEW PENDING REIMBUSEMENT REQUEST FOR LOGGED IN EMPLOYEE
	public List<ReimbursementPojo> viewPendingRequests(int employeeId);
	// READ FROM PENDING REIMBURSEMENTS TABLE
	public ReimbursementPojo readPendingRequest(int reimbursementId);
	// READ ALL VALUES FROM PENDING REQUESTS TABLE
	public List<ReimbursementPojo> viewAllPendingRequests();
}
