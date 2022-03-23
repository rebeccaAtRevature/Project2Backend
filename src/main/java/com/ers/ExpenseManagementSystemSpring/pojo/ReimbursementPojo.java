package com.ers.ExpenseManagementSystemSpring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReimbursementPojo {
	private int reimbursementId;
	private int resolvedReimbursementId;
	private int requestingEmployeeId;
	private double reimbursementAmount;
	private boolean reimbursementPending;
	private boolean requestApproved;
	private String dateOfRequest;
	private String dateResolved;
	private byte receiptImage;
	
	
	// Constructor for testing Pending Requests
	public ReimbursementPojo(int reimbusermentId, int requestingEmployeeId, double reimbursementAmount, boolean reimbursementPending) {
		this.reimbursementId = reimbusermentId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
	}

	// Constructor for Pending Requests
	public ReimbursementPojo(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
			boolean reimbursementPending, String dateOfRequest, byte receiptImage) {
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
		this.dateOfRequest = dateOfRequest;
	}
	
	// Constructor for adding Resolved Requests
	public ReimbursementPojo(int reimbursementId, boolean requestApproved) {		
		this.reimbursementId = reimbursementId;
		this.requestApproved = requestApproved;
	}
	// Constructor for testing Resolved Requests
	public ReimbursementPojo(int resolvedReimbusementId, int reimbursementId, int requestingEmployeeId,
			double reimbursementAmount, boolean reimbursementPending, boolean requestApproved) {
		this.resolvedReimbursementId = resolvedReimbusementId;
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
		this.requestApproved = requestApproved;
	}



}
