package com.ers.ExpenseManagementSystemSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_details")
public class EmployeeEntity {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "employee_first_name")
	private String employeeFirstName;

	@Column(name = "employee_last_name")
	private String employeeLastName;

	@Column(name = "employee_phone_number")
	private String employeePhoneNumber;

	@Column(name = "employee_address")
	private String employeeAddress;

	@Column(name = "employee_password")
	private String employeePassword;

	@Column(name = "employee_image_url")
	private String employeeImageUrl;
	
	public EmployeeEntity(int requestingEmployeeId) {
	}
}
