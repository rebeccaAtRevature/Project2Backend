package com.ers.ExpenseManagementSystemSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ers.ExpenseManagementSystemSpring.pojo.ReimbursementPojo;
import com.ers.ExpenseManagementSystemSpring.service.ReimbursementService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ResolvedReimbursementController {
	
	@Autowired
	ReimbursementService reimbursementService;
	
//    // VIEW RESOLVED REIMBURSEMENT REQUESTS FOR LOGGED IN EMPLOYEE
//    @GetMapping("r-reimbursements/{employeeId}")
//    List<ReimbursementPojo> viewResolvedRequests(@PathVariable("employeeId") int employeeId) {
//        return reimbursementService.viewResolvedRequests(employeeId);
//    }
//    // APPROVE OR DENY PENDING REIMBURSEMENT REQUESTS
//    @PostMapping("reimbursement")
//    public ReimbursementPojo approveOrDeny(@RequestBody ReimbursementPojo reimbursementPojo) {
//        return reimbursementService.approveOrDeny(reimbursementPojo);
//    }
//    // READ ALL VALUES FROM RESOLVED REQUESTS TABLE
//    @GetMapping("r-reimbursements")
//    public List<ReimbursementPojo> viewAllResolvedRequests() {
//        return reimbursementService.viewAllResolvedRequests();
//    }
//    // READ ALL PENDING AND RESOLVED REIMBURSEMENTS FOR ANY SINGLE EMPLOYEE
//    @GetMapping("reimbursements/{employeeId}")
//    public List<ReimbursementPojo> viewAllRequests(@PathVariable("employeeId") int employeeId) {
//        return reimbursementService.viewAllRequests(employeeId);
//    }
}
