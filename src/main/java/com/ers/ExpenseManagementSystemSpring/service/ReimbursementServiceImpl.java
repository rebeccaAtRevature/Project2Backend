package com.ers.ExpenseManagementSystemSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ers.ExpenseManagementSystemSpring.dao.EmployeeDao;
import com.ers.ExpenseManagementSystemSpring.dao.ReimbursementDao;
import com.ers.ExpenseManagementSystemSpring.dao.ResolvedReimbursementDao;
import com.ers.ExpenseManagementSystemSpring.entity.EmployeeEntity;
import com.ers.ExpenseManagementSystemSpring.entity.ReimbursementEntity;
import com.ers.ExpenseManagementSystemSpring.entity.ResolvedReimbursementEntity;
import com.ers.ExpenseManagementSystemSpring.exception.SystemException;
import com.ers.ExpenseManagementSystemSpring.pojo.ImagePojo;
import com.ers.ExpenseManagementSystemSpring.pojo.ReimbursementPojo;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class ReimbursementServiceImpl implements ReimbursementService {
	
	@Autowired
	ReimbursementDao reimbursementDao;
	@Autowired
	ResolvedReimbursementDao resolvedReimbursementDao;
	@Autowired
	ImageService imageService;
	@Autowired
	EmployeeDao employeeDao;
	
	// SUBMIT A REIMBURSEMENT REQUEST
	@Transactional
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo, MultipartFile reimbursementUpload) throws SystemException {
		log.info("Entering submitRequest() in Service Layer");
		System.out.println(reimbursementPojo.getRequestingEmployeeId());
		EmployeeEntity employeeEntity = employeeDao.getById(reimbursementPojo.getRequestingEmployeeId());
		ReimbursementEntity reimbursementEntity = new ReimbursementEntity(employeeEntity,reimbursementPojo.getReimbursementAmount(),reimbursementPojo.isReimbursementPending());
		reimbursementDao.save(reimbursementEntity);
		ImagePojo imagePojo = imageService.save(reimbursementUpload,reimbursementEntity);
		ReimbursementPojo returnReimbursementPojo = new ReimbursementPojo(reimbursementEntity.getReimbursementId(), 
				reimbursementEntity.getEmployeeEntity().getEmployeeId(), 
				reimbursementEntity.getReimbursementAmount(),
				reimbursementEntity.isReimbursementPending(),
				reimbursementEntity.getDateOfRequest(),
				imagePojo
				);
		log.info("Exiting submitRequest() in Service Layer");	
		return returnReimbursementPojo;		
	}
	// ADD TO RESOLVED REIMBURSEMENTS TABLE
	@Override
	@Transactional
	public ReimbursementPojo addResolvedRequest(ReimbursementPojo reimbursementPojo) {
		log.info("Entering addResolvedRequest() in Service Layer");
		ReimbursementEntity reimbursementEntity = reimbursementDao.getById(reimbursementPojo.getReimbursementId());
		ResolvedReimbursementEntity resolvedReimbursementEntity = new ResolvedReimbursementEntity(reimbursementEntity,reimbursementPojo.isRequestApproved());
		resolvedReimbursementDao.saveAndFlush(resolvedReimbursementEntity);
		ReimbursementPojo returnReimbursementPojo = new ReimbursementPojo( resolvedReimbursementEntity.getReimbursementEntity().getReimbursementId(),
				resolvedReimbursementEntity.getResolvedReimbursementId(),
				resolvedReimbursementEntity.getReimbursementEntity().getEmployeeEntity().getEmployeeId(), 
				resolvedReimbursementEntity.getReimbursementEntity().getReimbursementAmount(), 
				resolvedReimbursementEntity.getReimbursementEntity().isReimbursementPending(), 
				resolvedReimbursementEntity.isRequestApproved(), 
				resolvedReimbursementEntity.getReimbursementEntity().getDateOfRequest(), 
				resolvedReimbursementEntity.getDateResolved(),
				reimbursementPojo.getReimbursementImage());
		log.info("Exiting addResolvedRequest() in Service Layer");
		return returnReimbursementPojo;
	}
	// UPDATE REIMBURSEMENTS TABLE
	@Override
	@Transactional
	public ReimbursementPojo updatePendingRequest(ReimbursementPojo reimbursementPojo) {
		log.info("Entered updatePendingRequest() in Service Layer");
		EmployeeEntity employeeEntity = employeeDao.getById(reimbursementPojo.getRequestingEmployeeId());
		ReimbursementEntity reimbursementEntity = new ReimbursementEntity(reimbursementPojo.getReimbursementId(),employeeEntity,reimbursementPojo.getReimbursementAmount(),false,reimbursementPojo.getDateOfRequest());
		reimbursementDao.save(reimbursementEntity);
		ReimbursementPojo returnReimbursementPojo= new ReimbursementPojo(reimbursementEntity.getReimbursementId(), 
				reimbursementEntity.getEmployeeEntity().getEmployeeId(), 
				reimbursementEntity.getReimbursementAmount(),
				reimbursementEntity.isReimbursementPending(),
				reimbursementEntity.getDateOfRequest(),
				reimbursementPojo.getReimbursementImage());
		log.info("Exited updatePendingRequest() in Service Layer");
		return returnReimbursementPojo;
	}
	// VIEW PENDING REIMBUSEMENT REQUEST FOR LOGGED IN EMPLOYEE
	@Override
	@Transactional
	public List<ReimbursementPojo> viewPendingRequests(int employeeId) {
		log.info("Entering viewPendingRequests in Service Layer");
		List<ReimbursementPojo> allPendingRequestPojo = new ArrayList<ReimbursementPojo>();
		List<ReimbursementEntity> allPendingRequestEntity = reimbursementDao.viewPendingRequests(employeeId);
		allPendingRequestEntity.forEach(reimbursementEntity -> {
			ReimbursementPojo reimbursementPojo= new ReimbursementPojo(reimbursementEntity.getReimbursementId(), 
					reimbursementEntity.getEmployeeEntity().getEmployeeId(), 
					reimbursementEntity.getReimbursementAmount(),
					reimbursementEntity.isReimbursementPending(),
					reimbursementEntity.getDateOfRequest(),
					imageService.getImage(reimbursementEntity.getImageEntity().getImageId()));
			allPendingRequestPojo.add(reimbursementPojo);
		});
		log.info("Exiting viewPendingRequests in Service Layer");
		return allPendingRequestPojo;
	}
	// VIEW RESOLVED REIMBURSEMENT REQUESTS FOR LOGGED IN EMPLOYEE
	@Override
	@Transactional
	public List<ReimbursementPojo> viewResolvedRequests(int employeeId) {
		log.info("Entering viewResolvedRequests in Service Layer");
		List<ReimbursementPojo> allResolvedRequestPojo = new ArrayList<ReimbursementPojo>();
		List<ResolvedReimbursementEntity> allResolvedRequestEntity = resolvedReimbursementDao.viewResolvedRequests(employeeId);
		allResolvedRequestEntity.forEach(resolvedReimbursementEntity -> {
			ReimbursementPojo reimbursementPojo = new ReimbursementPojo( resolvedReimbursementEntity.getReimbursementEntity().getReimbursementId(),
					resolvedReimbursementEntity.getResolvedReimbursementId(),
					resolvedReimbursementEntity.getReimbursementEntity().getEmployeeEntity().getEmployeeId(), 
					resolvedReimbursementEntity.getReimbursementEntity().getReimbursementAmount(), 
					resolvedReimbursementEntity.getReimbursementEntity().isReimbursementPending(), 
					resolvedReimbursementEntity.isRequestApproved(), 
					resolvedReimbursementEntity.getReimbursementEntity().getDateOfRequest(), 
					resolvedReimbursementEntity.getDateResolved(), 
					imageService.getImage(resolvedReimbursementEntity.getReimbursementEntity().getImageEntity().getImageId())
			);
			allResolvedRequestPojo.add(reimbursementPojo);
		});
		log.info("Exiting viewResolvedRequests in Service Layer");
		return allResolvedRequestPojo;
	}
	// READ A SPECIFIC PENDING REIMBURSEMENT FROM TABLE
	@Override
	@Transactional
	public ReimbursementPojo readPendingRequest(int reimbursementId) {
		log.info("Entering readPendingRequest() in Service Layer");
		Optional<ReimbursementEntity> optional = reimbursementDao.findById(reimbursementId);
		ReimbursementPojo reimbursementPojo = null;
		if(optional.isPresent()) {
			ReimbursementEntity reimbursementEntity = optional.get();
			reimbursementPojo = new ReimbursementPojo(reimbursementEntity.getReimbursementId(), 
					reimbursementEntity.getEmployeeEntity().getEmployeeId(), 
					reimbursementEntity.getReimbursementAmount(),
					reimbursementEntity.isReimbursementPending(),
					reimbursementEntity.getDateOfRequest(),
					imageService.getImage(reimbursementEntity.getImageEntity().getImageId())
			);
		}
		log.info("Exiting readPendingRequest() in Service Layer");
		return reimbursementPojo;
	}
	// READ ALL VALUES FROM PENDING REQUESTS TABLE
	@Override
	@Transactional
	public List<ReimbursementPojo> viewAllPendingRequests() {
		log.info("Entering viewAllPendingRequests() in Service Layer");
		List<ReimbursementPojo> allPendingRequestPojo = new ArrayList<ReimbursementPojo>();
		List<ReimbursementEntity> allPendingRequestEntity = reimbursementDao.findByReimbursementPending(true);
		allPendingRequestEntity.forEach(reimbursementEntity -> {
			ReimbursementPojo reimbursementPojo= new ReimbursementPojo(reimbursementEntity.getReimbursementId(), 
					reimbursementEntity.getEmployeeEntity().getEmployeeId(), 
					reimbursementEntity.getReimbursementAmount(),
					reimbursementEntity.isReimbursementPending(),
					reimbursementEntity.getDateOfRequest(),
					imageService.getImage(reimbursementEntity.getImageEntity().getImageId())
					);
			allPendingRequestPojo.add(reimbursementPojo);
		});
		log.info("Exiting viewAllPendingRequests() in Service Layer");
		return allPendingRequestPojo;
	}
	// READ ALL VALUES FROM RESOLVED REQUESTS TABLE
	@Override
	@Transactional
	public List<ReimbursementPojo> viewAllResolvedRequests() {
		log.info("Entering viewAllResolvedRequests() in Service Layer");
		List<ReimbursementPojo> allResolvedRequestPojo = new ArrayList<ReimbursementPojo>();
		List<ReimbursementEntity> allResolvedRequestEntity = reimbursementDao.findByReimbursementPending(false);
		allResolvedRequestEntity.forEach(reimbursementEntity -> {
			ReimbursementPojo reimbursementPojo = new ReimbursementPojo( reimbursementEntity.getReimbursementId(),
					reimbursementEntity.getResolvedReimbursementEntity().getResolvedReimbursementId(),
					reimbursementEntity.getEmployeeEntity().getEmployeeId(), 
					reimbursementEntity.getReimbursementAmount(), 
					reimbursementEntity.isReimbursementPending(), 
					reimbursementEntity.getResolvedReimbursementEntity().isRequestApproved(), 
					reimbursementEntity.getDateOfRequest(), 
					reimbursementEntity.getResolvedReimbursementEntity().getDateResolved(),
					imageService.getImage(reimbursementEntity.getImageEntity().getImageId())
					);
			allResolvedRequestPojo.add(reimbursementPojo);
		});
		log.info("Exiting viewAllResolvedRequests() in Service Layer");
		return allResolvedRequestPojo;
	}

	// READ ALL PENDING AND RESOLVED REIMBURSEMENTS FOR ANY SINGLE EMPLOYEE
	@Override
	@Transactional
	public List<ReimbursementPojo> viewAllRequests(int employeeId) {
		log.info("Entering viewAllRequests() in Service Layer");
		List<ReimbursementPojo> allRequestPojo = new ArrayList<ReimbursementPojo>();
		List<ReimbursementEntity> allRequestEntity = reimbursementDao.findByEmployeeId(employeeId);
		allRequestEntity.forEach(reimbursementEntity -> {
			ReimbursementPojo reimbursementPojo = new ReimbursementPojo( reimbursementEntity.getReimbursementId(),
					reimbursementEntity.getResolvedReimbursementEntity().getResolvedReimbursementId(),
					reimbursementEntity.getEmployeeEntity().getEmployeeId(), 
					reimbursementEntity.getReimbursementAmount(), 
					reimbursementEntity.isReimbursementPending(), 
					reimbursementEntity.getResolvedReimbursementEntity().isRequestApproved(), 
					reimbursementEntity.getDateOfRequest(), 
					reimbursementEntity.getResolvedReimbursementEntity().getDateResolved(),
					imageService.getImage(reimbursementEntity.getImageEntity().getImageId())
					);
			allRequestPojo.add(reimbursementPojo);
		});
		log.info("Exiting viewAllRequests() in Service Layer");
		return allRequestPojo;
	}
	// APPROVE OR DENY PENDING REIMBURSEMENT REQUESTS
	@Override
	@Transactional
	public ReimbursementPojo approveOrDeny(ReimbursementPojo reimbursementPojo) {
		log.info("Entering approveOrDeny() in Service Layer");
		
		// add to resolved request table
		addResolvedRequest(reimbursementPojo);
		
		// update reimbursement details table
		ReimbursementPojo returnReimbursement = updatePendingRequest(reimbursementPojo);
		
		log.info("Exiting approveOrDeny() in Service Layer");
		return returnReimbursement;
	}
}
