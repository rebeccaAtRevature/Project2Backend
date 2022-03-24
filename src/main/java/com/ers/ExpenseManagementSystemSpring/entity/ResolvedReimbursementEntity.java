package com.ers.ExpenseManagementSystemSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

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

	@OneToOne
	@JoinColumn(name = "reimbursement_id")
	private ReimbursementEntity reimbursementEntity;
	
	@Column(name = "request_approved")
	private boolean requestApproved;

	@Column(name = "date_resolved")
	@CreatedDate
	private String dateResolved;
	
	public ResolvedReimbursementEntity( boolean requestApproved2) {

	}

	public ResolvedReimbursementEntity(int reimbursementId, boolean requestApproved) {
		this.reimbursementEntity = new ReimbursementEntity(reimbursementId);
		this.requestApproved = requestApproved;
	}
	
}
