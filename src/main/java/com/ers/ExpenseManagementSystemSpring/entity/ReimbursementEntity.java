package com.ers.ExpenseManagementSystemSpring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

//	@Column(name = "requesting_employee_id")
//	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(referencedColumnName = "employee_id", table = "employee_details")
//	private int requestingEmployeeId;

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
	
	public ReimbursementEntity(int requestingEmployeeId, double reimbursementAmount, boolean reimbursementPending) {
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementPending = reimbursementPending;
	}
	
	
}
