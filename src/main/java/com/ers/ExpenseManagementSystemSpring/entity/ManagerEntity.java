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
@Table(name = "manager_details")
public class ManagerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private int managerId;

	@Column(name = "manager_first_name")
	private String managerFirstName;

	@Column(name = "manager_last_name")
	private String managerLastName;

	@Column(name = "manager_phone_number")
	private String managerPhoneNumber;

	@Column(name = "manager_address")
	private String managerAddress;

	@Column(name = "manager_password")
	private String managerPassword;

	@Column(name = "manager_image_url")
	private String managerImageUrl;

}
