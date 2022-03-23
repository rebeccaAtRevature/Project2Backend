package com.ers.ExpenseManagementSystemSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "resolved_reimbursements")
public class ResolvedReimbursementEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "resolved_reimbursement_id")
	private int resolvedReimbursementId;

//	@Column(name = "reimbursement_id")
//	@OneToOne(fetch = FetchType.LAZY)
//	@JoinColumn(referencedColumnName = "reimbursement_id", table = "reimbursement_details")
//	private String reimbursementId;

	@OneToOne
	@JoinColumn(name = "reimbursement_id")
	private ReimbursementEntity reimbursementEntity;
	
	
	@Column(name = "request_approved")
	private String requestApproved;

	@Column(name = "date_resolved")
	private String managerContact;

}
