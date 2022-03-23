package com.ers.ExpenseManagementSystemSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ers.ExpenseManagementSystemSpring.dao.ReimbursementDao;
import com.ers.ExpenseManagementSystemSpring.entity.ReimbursementEntity;
import com.ers.ExpenseManagementSystemSpring.pojo.ReimbursementPojo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ReimbursementServiceImpl implements ReimbursementService {
	
	@Autowired
	ReimbursementDao reimbursementDao;
	
	// SUBMIT A REIMBURSEMENT REQUEST
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) {
		log.info("Entering submitRequest() in Service Layer");
		ReimbursementEntity reimbursementEntity =new ReimbursementEntity(reimbursementPojo.getRequestingEmployeeId(),reimbursementPojo.getReimbursementAmount(),true);
		reimbursementDao.saveAndFlush(reimbursementEntity);
		reimbursementPojo = new ReimbursementPojo(reimbursementEntity.getReimbursementId(), reimbursementEntity.getRequestingEmployeeId(), reimbursementEntity.getReimbursementAmount(),true);
		log.info("Exiting submitRequest() in Service Layer");	
		return reimbursementPojo;		
	}
	// UPDATE REIMBURSEMENTS TABLE
	public ReimbursementPojo updatePendingRequest(ReimbursementPojo reimbursementPojo) {
		log.info("Entered updatePendingRequest() in Service Layer");
		ReimbursementEntity reimbursementEntity = new ReimbursementEntity(reimbursementPojo.getReimbursementId(),reimbursementPojo.getRequestingEmployeeId(),reimbursementPojo.getReimbursementAmount(),false,reimbursementPojo.getDateOfRequest());
		reimbursementDao.save(reimbursementEntity);
		reimbursementPojo= new ReimbursementPojo(reimbursementEntity.getReimbursementId(), reimbursementEntity.getRequestingEmployeeId(), reimbursementEntity.getReimbursementAmount(),reimbursementPojo.isReimbursementPending(),reimbursementPojo.getDateOfRequest(),reimbursementPojo.getReceiptImage());
		log.info("Exited updatePendingRequest() in Service Layer");
		return reimbursementPojo;
	}
	// VIEW PENDING REIMBUSEMENT REQUEST FOR logGED IN EMPLOYEE
	public List<ReimbursementPojo> viewPendingRequests(int employeeId) {
		log.info("Entering viewPendingRequests in Service Layer");
		List<ReimbursementPojo> allPendingRequestPojo = new ArrayList<ReimbursementPojo>();
		List<ReimbursementEntity> allPendingRequestEntity = reimbursementDao.viewPendingRequests(employeeId);
		allPendingRequestEntity.forEach((reimbursementEntity) -> {
			ReimbursementPojo reimbursementPojo = new ReimbursementPojo(reimbursementEntity.getReimbursementId(), reimbursementEntity.getRequestingEmployeeId(), reimbursementEntity.getReimbursementAmount(),true);
			allPendingRequestPojo.add(reimbursementPojo);
		});
		log.info("Exiting viewPendingRequests in Service Layer");
		return allPendingRequestPojo;
	}
	// READ A SPECIFIC PENDING REIMBURSEMENT FROM TABLE
	public ReimbursementPojo readPendingRequest(int reimbursementId) {
		log.info("Entering readPendingRequest() in Service Layer");
		Optional<ReimbursementEntity> optional = reimbursementDao.findById(reimbursementId);
		ReimbursementPojo reimbursementPojo = null;
		if(optional.isPresent()) {
			ReimbursementEntity reimbursementEntity = optional.get();
			reimbursementPojo = new ReimbursementPojo(reimbursementEntity.getReimbursementId(), reimbursementEntity.getRequestingEmployeeId(), reimbursementEntity.getReimbursementAmount(),true);
		}
		log.info("Exiting readPendingRequest() in Service Layer");
		return reimbursementPojo;
	}
	// READ ALL VALUES FROM PENDING REQUESTS TABLE
	public List<ReimbursementPojo> viewAllPendingRequests() {
		log.info("Entering viewAllPendingRequests() in Service Layer");
		List<ReimbursementPojo> allPendingRequestPojo = new ArrayList<ReimbursementPojo>();
		List<ReimbursementEntity> allPendingRequestEntity = reimbursementDao.viewAllPendingRequests();
		allPendingRequestEntity.forEach((reimbursementEntity) -> {
			ReimbursementPojo reimbursementPojo = new ReimbursementPojo(reimbursementEntity.getReimbursementId(), reimbursementEntity.getRequestingEmployeeId(), reimbursementEntity.getReimbursementAmount(),true);
			allPendingRequestPojo.add(reimbursementPojo);
		});
		log.info("Exiting viewAllPendingRequests() in Service Layer");
		return allPendingRequestPojo;
	}
}
