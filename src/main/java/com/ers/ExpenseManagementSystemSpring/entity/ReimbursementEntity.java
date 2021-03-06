package com.ers.ExpenseManagementSystemSpring.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

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
	@CreatedDate
	private Date dateOfRequest;
	
	@OneToOne(mappedBy = "reimbursementEntity")
	private ResolvedReimbursementEntity resolvedReimbursementEntity;
	
	@OneToOne(mappedBy = "reimbursementEntity")
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

	public ReimbursementEntity(int reimbursementId, EmployeeEntity employeeEntity, double reimbursementAmount,
			boolean reimbursementPending, Date dateOfRequest) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeEntity = employeeEntity;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
		this.dateOfRequest = dateOfRequest;
	}

	
	
	
	
}
