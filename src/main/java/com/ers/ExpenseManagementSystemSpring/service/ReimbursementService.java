package com.ers.ExpenseManagementSystemSpring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ers.ExpenseManagementSystemSpring.exception.SystemException;
import com.ers.ExpenseManagementSystemSpring.pojo.ReimbursementPojo;

public interface ReimbursementService {
	// SUBMIT A REIMBURSEMENT REQUEST
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo, MultipartFile file) throws SystemException;
	// ADD TO RESOLVED REIMBURSEMENTS TABLE
	public ReimbursementPojo addResolvedRequest(ReimbursementPojo reimbursementPojo) ;
	// UPDATE REIMBURSEMENTS TABLE
	public ReimbursementPojo updatePendingRequest(ReimbursementPojo reimbursementPojo);
	// VIEW PENDING REIMBUSEMENT REQUEST FOR LOGGED IN EMPLOYEE
	public List<ReimbursementPojo> viewPendingRequests(int employeeId);
	// VIEW RESOLVED REIMBURSEMENT REQUESTS FOR LOGGED IN EMPLOYEE
	public List<ReimbursementPojo> viewResolvedRequests(int employeeId) ;
	// READ FROM PENDING REIMBURSEMENTS TABLE
	public ReimbursementPojo readPendingRequest(int reimbursementId);
	// READ ALL VALUES FROM PENDING REQUESTS TABLE
	public List<ReimbursementPojo> viewAllPendingRequests();
	// READ ALL VALUES FROM RESOLVED REQUESTS TABLE
	public List<ReimbursementPojo> viewAllResolvedRequests() ;
	// READ ALL PENDING AND RESOLVED REIMBURSEMENTS FOR ANY SINGLE EMPLOYEE
	public List<ReimbursementPojo> viewAllRequests(int employeeId) ;
	// APPROVE OR DENY PENDING REIMBURSEMENT REQUESTS
	public ReimbursementPojo approveOrDeny(ReimbursementPojo reimbursementPojo) ;
	
}
