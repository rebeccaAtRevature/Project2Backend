package com.ers.ExpenseManagementSystemSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ers.ExpenseManagementSystemSpring.pojo.ManagerPojo;
import com.ers.ExpenseManagementSystemSpring.service.ManagerService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
    // LOGIN
    @GetMapping("managers/{managerId}/{managerPassword}")
    public ManagerPojo managerLogin(@PathVariable("managerId") int managerId, @PathVariable("managerPassword") String managerPassword) {
        return managerService.managerLogin(managerId, managerPassword);
    }
}
