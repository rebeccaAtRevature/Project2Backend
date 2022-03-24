package com.ers.ExpenseManagementSystemSpring.pojo;

import org.springframework.web.multipart.MultipartFile;

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
	private MultipartFile reimbursementUpload;
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
			boolean reimbursementPending, String dateOfRequest, ImagePojo reimbursementImage) {
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


	// Constructor for returning Pending Requests
	public ReimbursementPojo(int reimbursementId, int resolvedReimbursementId, int requestingEmployeeId,
			double reimbursementAmount, boolean reimbursementPending, boolean requestApproved, String dateOfRequest,
			String dateResolved, ImagePojo reimbursementImage) {
		this.reimbursementId = reimbursementId;
		this.resolvedReimbursementId = resolvedReimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
		this.requestApproved = requestApproved;
		this.dateOfRequest = dateOfRequest;
		this.dateResolved = dateResolved;
		this.reimbursementImage = reimbursementImage;
	}
	
	
}
