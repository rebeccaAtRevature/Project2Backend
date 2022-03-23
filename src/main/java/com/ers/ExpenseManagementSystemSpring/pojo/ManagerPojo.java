package com.ers.ExpenseManagementSystemSpring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerPojo {
	
	private int managerId;
	private String managerFirstName;
	private String managerLastName;
	private String managerContact;
	private String managerAddress;
	private String managerPassword;
	private String managerImageURL;
	
}
