package com.ers.ExpenseManagementSystemSpring.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ers.ExpenseManagementSystemSpring.dao.ResolvedReimbursementDao;
import com.ers.ExpenseManagementSystemSpring.entity.ReimbursementEntity;
import com.ers.ExpenseManagementSystemSpring.entity.ResolvedReimbursementEntity;
import com.ers.ExpenseManagementSystemSpring.pojo.ReimbursementPojo;

import exceptions.SystemException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ResolvedReimbursementServiceImpl implements ResolvedReimbursementService{
	
	@Autowired
	ResolvedReimbursementDao resolvedReimbursementDao;
	
	// VIEW RESOLVED REIMBURSEMENT REQUESTS FOR LOGGED IN EMPLOYEE
	@Override
	public List<ReimbursementPojo> viewResolvedRequests(int employeeId) {
		log.info("Entering viewResolvedRequests in DAO");
		List<ReimbursementPojo> allResolvedRequestPojo = resolvedReimbursementDao.viewResolvedRequests(employeeId);
		log.info("Exiting viewResolvedRequests in DAO");
		return allResolvedRequestPojo;
	}
	// ADD TO RESOLVED REIMBURSEMENTS TABLE
	@Override
	public ReimbursementPojo addResolvedRequest(ReimbursementPojo reimbursementPojo) {
		log.info("Entering addResolvedRequest() in Manager DAO");
		ResolvedReimbursementEntity resolvedreimbursementEntity = new ResolvedReimbursementPojo(resolvedReimbursementEntity.getReimbursementId(), resolvedReimbursementEntity.getRequestingEmployeeId(), resolvedReimbursementEntity.getReimbursementAmount(),true);
		log.info("Exiting addResolvedRequest() in Manager DAO");
		
		return reimbursementPojo;
	}
	// APPROVE OR DENY PENDING REIMBURSEMENT REQUESTS
	@Override
	public ReimbursementPojo approveOrDeny(ReimbursementPojo reimbursementPojo) {
		LOG.info("Entering approveOrDeny() in Manager DAO");
			
		addResolvedRequest(new ReimbursementPojo(reimbursementPojo.getReimbursementId(), reimbursementPojo.isRequestApproved()));
			
		returnReimbursement = updatePendingRequest(reimbursementPojo);
			
			// update request will reset request approved to false, fix that here.
			returnReimbursement.setRequestApproved(reimbursementPojo.isRequestApproved());
			LOG.debug(returnReimbursement.isRequestApproved());
			
			conn.commit();
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		LOG.info("Exiting approveOrDeny() in Manager DAO");
		return returnReimbursement;
	}
	// READ ALL VALUES FROM RESOLVED REQUESTS TABLE
	@Override
	public List<ReimbursementPojo> viewAllResolvedRequests() {
		LOG.info("Entering viewAllResolvedRequests() in Manager DAO");
		List<ReimbursementPojo> allResolvedRequestPojo = resolvedReimbursementDao.viewResolvedRequests(employeeId);
		LOG.info("Exiting viewAllResolvedRequests() in Manager DAO");
		
		return resolvedRequest;
	}
	// READ ALL PENDING AND RESOLVED REIMBURSEMENTS FOR ANY SINGLE EMPLOYEE
	@Override
	public List<ReimbursementPojo> viewAllRequests(int employeeId) {
		LOG.info("Entering viewAllRequests() in Manager DAO");
		
		Connection conn = DBUtil.obtainConnection();
		
		List<ReimbursementPojo> allRequests = new ArrayList<ReimbursementPojo>();
		
		try {
			Statement stmt = conn.createStatement();
			
			// Make a left join to pull information from resolved_reimbursements for 
			String query = "SELECT resolved_reimbursement_id, reimbursement_details.reimbursement_id, requesting_employee_id, reimbursement_amount, reimbursement_pending, request_approved, date_of_request, date_resolved FROM reimbursement_details LEFT JOIN resolved_reimbursements ON reimbursement_details.reimbursement_id=resolved_reimbursements.reimbursement_id WHERE requesting_employee_id="+employeeId+" ORDER BY reimbursement_details.reimbursement_id";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				// Add all pending reimbursements to all requests array
				ReimbursementPojo reimbursementPojo = new ReimbursementPojo(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getBoolean(5), rs.getBoolean(6), rs.getString(7), rs.getString(8));
				allRequests.add(reimbursementPojo);
			}
			
		} catch (SQLException e) {
			
			throw new SystemException();
		}
		
		
		LOG.info("Exiting viewAllRequests() in Manager DAO");
		
		return allRequests;
	}
	
}
