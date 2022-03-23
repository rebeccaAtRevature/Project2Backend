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
	private int imageId;
	private String imageName;
	private String imageType;
	private byte[] imageData;
	

	// Constructor for adding Pending Requests
	public ReimbursementPojo(int requestingEmployeeId, double reimbursementAmount, boolean reimbursementPending,
			String imageName, String imageType, byte[] imageData) {
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
	}
		
	// Constructor for Returning Pending Requests
	public ReimbursementPojo(int reimbursementId, int requestingEmployeeId, double reimbursementAmount,
			boolean reimbursementPending, String dateOfRequest, int imageId, String imageName, String imageType,
			byte[] imageData) {
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
		this.dateOfRequest = dateOfRequest;
		this.imageId = imageId;
		this.imageName = imageName;
		this.imageType = imageType;
		this.imageData = imageData;
	}
	
	// Constructor for adding Resolved Requests
	public ReimbursementPojo(int reimbursementId, boolean requestApproved) {		
		this.reimbursementId = reimbursementId;
		this.requestApproved = requestApproved;
	}
	
}
