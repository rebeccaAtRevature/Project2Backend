package com.ers.ExpenseManagementSystemSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reimbursement_details")
public class ReimbursementEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reimbursement_id")
	private int reimbursementId;

	@ManyToOne
	@JoinColumn(name = "requesting_employee_id")
	private EmployeeEntity employeeEntity;
	
	@Column(name = "reimbursement_amount")
	private double reimbursementAmount;

	@Column(name = "reimbursement_pending")
	private boolean reimbursementPending;

	@Column(name = "date_of_request")
	private String dateOfRequest;
	
	@OneToOne(mappedBy = "reimbursementEntity")
	private ResolvedReimbursementEntity resolvedReimbursementEntity;
	
	@OneToOne(mappedBy = "imageEntity")
	private ImageEntity imageEntity;
	
	// Constructor for adding Pending Requests
	public ReimbursementEntity(EmployeeEntity employeeEntity, double reimbursementAmount, boolean reimbursementPending) {
		this.employeeEntity = employeeEntity;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
	}

	public ReimbursementEntity(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public ReimbursementEntity(int reimbursementId, int employeeId, double reimbursementAmount,
			boolean reimbursementPending, String dateOfRequest) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeEntity = new EmployeeEntity(employeeId);
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
		this.dateOfRequest = dateOfRequest;
	}

	
	
	
	
}
