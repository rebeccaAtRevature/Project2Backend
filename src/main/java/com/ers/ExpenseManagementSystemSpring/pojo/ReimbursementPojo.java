package com.ers.ExpenseManagementSystemSpring.pojo;

import java.util.Date;

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
	private Date dateOfRequest;
	private Date dateResolved;
	private ImagePojo reimbursementImage;
	

	// Constructor for adding Pending Requests
	public ReimbursementPojo(int requestingEmployeeId, double reimbursementAmount, boolean reimbursementPending,
			ImagePojo reimbursementImage) {
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
		this.reimbursementImage = reimbursementImage;
		
	}
		
	// Constructor for Returning Pending Requests
	public ReimbursementPojo(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
			boolean reimbursementPending, Date dateOfRequest, ImagePojo reimbursementImage) {
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
		this.dateOfRequest = dateOfRequest;
		this.reimbursementImage = reimbursementImage;
	}
	
	// Constructor for adding Resolved Requests
	public ReimbursementPojo(int reimbursementId, boolean requestApproved) {		
		this.reimbursementId = reimbursementId;
		this.requestApproved = requestApproved;
	}
	
	
}
