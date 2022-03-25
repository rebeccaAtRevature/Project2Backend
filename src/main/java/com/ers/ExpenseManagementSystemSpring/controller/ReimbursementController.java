package com.ers.ExpenseManagementSystemSpring.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ers.ExpenseManagementSystemSpring.exception.SystemException;
import com.ers.ExpenseManagementSystemSpring.pojo.ImagePojo;
import com.ers.ExpenseManagementSystemSpring.pojo.ReimbursementPojo;
import com.ers.ExpenseManagementSystemSpring.service.ImageService;
import com.ers.ExpenseManagementSystemSpring.service.ReimbursementService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ReimbursementController {
	
	@Autowired
	ReimbursementService reimbursementService;
	@Autowired
	ImageService imageService;
	
	// SUBMIT A REIMBURSEMENT REQUEST
    @PostMapping("reimbursements")
    ResponseEntity<String> submitRequest(@RequestPart("properties") @Valid ReimbursementPojo reimbursementPojo,
            @RequestPart("file") @Valid @NotNull MultipartFile file) {
    	try {
        	reimbursementService.submitRequest(reimbursementPojo, file);
			return ResponseEntity.status(HttpStatus.OK)
                    .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
		} catch (SystemException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
		}
    }
    // VIEW PENDING REIMBUSEMENT REQUEST FOR LOGGED IN EMPLOYEE
    @GetMapping("p-reimbursements/{employeeId}")
    public List<ReimbursementPojo> viewPendingRequests(@PathVariable("employeeId") int employeeId) {
        return reimbursementService.viewPendingRequests(employeeId);
    }
    // READ FROM PENDING REIMBURSEMENTS TABLE
    @GetMapping("p-reimbursement/{reimbursementId}")
    public ReimbursementPojo readPendingRequest(@PathVariable("reimbursementId") int reimbursementId) {
        return reimbursementService.readPendingRequest(reimbursementId);
    }
    // READ ALL VALUES FROM PENDING REQUESTS TABLE
    @GetMapping("p-reimbursements")
    public List<ReimbursementPojo> viewAllPendingRequests() {
        return reimbursementService.viewAllPendingRequests();
    }
    // VIEW RESOLVED REIMBURSEMENT REQUESTS FOR LOGGED IN EMPLOYEE
    @GetMapping("r-reimbursements/{employeeId}")
    List<ReimbursementPojo> viewResolvedRequests(@PathVariable("employeeId") int employeeId) {
        return reimbursementService.viewResolvedRequests(employeeId);
    }
    // APPROVE OR DENY PENDING REIMBURSEMENT REQUESTS
    @PostMapping("reimbursement")
    public ReimbursementPojo approveOrDeny(@RequestBody ReimbursementPojo reimbursementPojo) {
        return reimbursementService.approveOrDeny(reimbursementPojo);
    }
    // READ ALL VALUES FROM RESOLVED REQUESTS TABLE
    @GetMapping("r-reimbursements")
    public List<ReimbursementPojo> viewAllResolvedRequests() {
        return reimbursementService.viewAllResolvedRequests();
    }
    // READ ALL PENDING AND RESOLVED REIMBURSEMENTS FOR ANY SINGLE EMPLOYEE
    @GetMapping("reimbursements/{employeeId}")
    public List<ReimbursementPojo> viewAllRequests(@PathVariable("employeeId") int employeeId) {
        return reimbursementService.viewAllRequests(employeeId);
    }
    // RETRIEVE IMAGES
    @GetMapping("images/{imageId}")
    public ImagePojo retrieveImage(@PathVariable("imageId") int imageId){
    	return imageService.getImage(imageId);
    };
}
