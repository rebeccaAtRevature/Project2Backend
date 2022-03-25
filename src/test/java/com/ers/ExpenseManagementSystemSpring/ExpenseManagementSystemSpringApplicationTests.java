package com.ers.ExpenseManagementSystemSpring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.ers.ExpenseManagementSystemSpring.dao.EmployeeDao;
import com.ers.ExpenseManagementSystemSpring.dao.ManagerDao;
import com.ers.ExpenseManagementSystemSpring.dao.ReimbursementDao;
import com.ers.ExpenseManagementSystemSpring.dao.ResolvedReimbursementDao;
import com.ers.ExpenseManagementSystemSpring.entity.EmployeeEntity;
import com.ers.ExpenseManagementSystemSpring.entity.ImageEntity;
import com.ers.ExpenseManagementSystemSpring.entity.ManagerEntity;
import com.ers.ExpenseManagementSystemSpring.entity.ReimbursementEntity;
import com.ers.ExpenseManagementSystemSpring.entity.ResolvedReimbursementEntity;
import com.ers.ExpenseManagementSystemSpring.pojo.EmployeePojo;
import com.ers.ExpenseManagementSystemSpring.pojo.ManagerPojo;


import com.ers.ExpenseManagementSystemSpring.service.EmployeeServiceImpl;
import com.ers.ExpenseManagementSystemSpring.service.ManagerServiceImpl;
import com.ers.ExpenseManagementSystemSpring.service.ReimbursementServiceImpl;

import exceptions.SystemException;

@TestInstance(Lifecycle.PER_CLASS)
@RunWith(MockitoJUnitRunner.class)
class ExpenseManagementSystemSpringApplicationTests {

	@InjectMocks
	EmployeeServiceImpl employeeService;

	@Mock
	EmployeeDao employeeDao;
	
	@InjectMocks
	ManagerServiceImpl managerService;
	
	@Mock
	ManagerDao managerDao;
	
	@InjectMocks
	ReimbursementServiceImpl reimbursementService;
	
	@Mock
	ReimbursementDao reimbursementDao;
	
	@Mock
	ResolvedReimbursementDao resolvedReimbursementDao;

	@BeforeAll
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testEmployeeLogin() {
		
	}
	
	@Test
	void testFetchEmployee() {
		when(employeeDao.findById(100)).thenReturn(
				Optional.of(new EmployeeEntity(100, "Lucy", "Mae", "(546)309-3823", "566 Weelia Ct.", "1234", "")));
		EmployeePojo actualResult = employeeService.fetchEmployee(100);
		EmployeePojo expectedResult = new EmployeePojo(100, "Lucy", "Mae", "(546)309-3823", "566 Weelia Ct.", "1234","");

		assertEquals(actualResult, expectedResult);
		verify(employeeDao).findById(100);
	}
	
	@Test
	void testUpdateEmployee() {
		when(employeeDao.findById(100)).thenReturn(
				Optional.of(new EmployeeEntity(100, "Lucy", "Mae", "(546)309-3823", "566 Weelia Ct.", "1234", "")));
		EmployeePojo actualResult= employeeService.updateEmployee(new EmployeePojo(100, "Lucy", "Mae", "(546)309-0000", "566 Weelia Ct.", "1234", ""));
		EmployeePojo expectedResult = new EmployeePojo(100, "Lucy", "Mae", "(546)309-0000", "566 Weelia Ct.", "1234", "");	
		
		assertEquals(actualResult, expectedResult);
		verify(employeeDao).findById(100);
	}
	
	@Test
	void testViewAllEmployees() {
	List<EmployeeEntity> allEmployeesEntity = new ArrayList<EmployeeEntity>();
	allEmployeesEntity.add(new EmployeeEntity(100, "Lucy", "Mae", "(546)309-3823", "566 Weelia Ct.", "1234", ""));
	allEmployeesEntity.add(new EmployeeEntity(100, "Tam", "Rany", "(546)309-4536", "566 Weelia Ct.", "2550", ""));
	when(employeeDao.findAll()).thenReturn(allEmployeesEntity);
	List<EmployeePojo> allEmployeesPojo = new ArrayList<EmployeePojo>();
	allEmployeesPojo.add(new EmployeePojo(100, "Lucy", "Mae", "(546)309-3823", "566 Weelia Ct.", "1234", ""));
	allEmployeesPojo.add(new EmployeePojo(100, "Tam", "Rany", "(546)309-4536", "566 Weelia Ct.", "2550", ""));
		
	List<EmployeePojo> actualResult=  employeeService.viewAllEmployees();
	List<EmployeePojo> expectedResult = allEmployeesPojo;
	assertEquals(actualResult, expectedResult);
	}

	@Test
	void testFetchManager() {
		when(managerDao.findById(100)).thenReturn(
				Optional.of(new ManagerEntity(100, "Roz", "Slug",  "(546)354-3218" , "354 Watching Rd." , "2468","")));
		ManagerPojo actualResult= managerService.fetchManager(100);
		ManagerPojo expectedResult = new ManagerPojo(100, "Roz", "Slug",  "(546)354-3218" , "354 Watching Rd." , "2468","");
		
		assertEquals(actualResult, expectedResult);
		verify(managerDao).findById(100);
		
	}
		
/*	@Test
	void testAddResolvedRequest() {
		String bytePlaceHolder="byte";
		bytePlaceHolder.getBytes();
		ReimbursementEntity reimbursementEntity = new ReimbursementEntity();
		reimbursementEntity.setEmployeeEntity(new EmployeeEntity());
		reimbursementEntity.setImageEntity(new ImageEntity());
		reimbursementEntity.setReimbursementId(1);
		
		ResolvedReimbursementEntity resolvedReimbursementEntity = new ResolvedReimbursementEntity();
		resolvedReimbursementEntity.setResolvedReimbursementId(1);
		resolvedReimbursementEntity.setReimbursementEntity(reimbursementEntity);
		//ResolvedReimbursementEntity resolvedReimbursementEntity = new ResolvedReimbursementEntity(1, new EmployeeEntity(1,"","","","","",""), 1, true,"", new ResolvedReimbursementEntity(1,true,""), new ImageEntity(1,"","",bytePlaceHolder.getBytes()));
		when(resolvedReimbursementDao.saveAndFlush(new ResolvedReimbursementEntity(1, false))).thenReturn(resolvedReimbursementEntity);
		
		ReimbursementPojo reimbursementPojo = new ReimbursementPojo();
		//reimbursementPojo.setReimbursementId(resolvedReimbursementEntity.getResolvedReimbursementId());
		
		reimbursementPojo.setRequestApproved(false);
		
		ReimbursementPojo expectedResult = new ReimbursementPojo();
		expectedResult.setReimbursementId(1);
		expectedResult.setRequestApproved(false);
				
		
		ReimbursementPojo actualResult=reimbursementService.addResolvedRequest(reimbursementPojo);
		//ReimbursementPojo expectedResult = new ReimbursementPojo(1, 1, 1, 1,true,true,"","", 1, "","",bytePlaceHolder.getBytes());
		assertEquals(actualResult.getReimbursementId(), expectedResult.getReimbursementId());
	}*/
	
	
/*	@Test
	void testReadPendingRequest() {
		
		String bytePlaceHolder="byte";
		bytePlaceHolder.getBytes();
		when(reimbursementDao.findById(1)).thenReturn(Optional.of(new ReimbursementEntity(1, new EmployeeEntity(1,"","","","","",""), 1, true,"", new ResolvedReimbursementEntity(1,true,""), new ImageEntity(1,"","",bytePlaceHolder.getBytes()))));
		
		ReimbursementPojo actualResult= reimbursementService.readPendingRequest(1);
		ReimbursementPojo expectedResult= new ReimbursementPojo (1, 1, 1, 1,true,true,"","", 1, "","",bytePlaceHolder.getBytes());
		assertEquals(actualResult, expectedResult);
	}*/
	
/*	@Test
	void testUpdatePendingRequest() {
		String bytePlaceHolder="byte";
		bytePlaceHolder.getBytes();
		when(reimbursementDao.findById(1)).thenReturn(
				Optional.of(new ReimbursementEntity(1, new EmployeeEntity(1,"","","","","",""), 1, true,"", new ResolvedReimbursementEntity(1,true,""), new ImageEntity(1,"","",bytePlaceHolder.getBytes()))));
		
		ReimbursementPojo actualResult= reimbursementService.updatePendingRequest(new ReimbursementPojo(1, 1, 1, 1,true,false,"","", 1, "","",bytePlaceHolder.getBytes()));
		ReimbursementPojo expectedResult = new ReimbursementPojo(1, 1, 1, 1,true,false,"","", 1, "","",bytePlaceHolder.getBytes());
		
		
		assertEquals(actualResult, expectedResult);
		//verify(reimbursementDao).findById(1);	
	}*/
	
/*	@Test
	void testViewAllPendingRequest() {
		String bytePlaceHolder="byte";
		bytePlaceHolder.getBytes();
			List<ReimbursementEntity> allReimbursementEntity = new ArrayList<ReimbursementEntity>();
			allReimbursementEntity.add(new ReimbursementEntity(1, new EmployeeEntity(1,"","","","","",""), 1, true,"", new ResolvedReimbursementEntity(1,true,""), new ImageEntity(1,"","",bytePlaceHolder.getBytes())));
			allReimbursementEntity.add(new ReimbursementEntity(1, new EmployeeEntity(2,"","","","","",""), 1, true,"", new ResolvedReimbursementEntity(1,true,""), new ImageEntity(1,"","",bytePlaceHolder.getBytes())));
			when(reimbursementDao.findAll()).thenReturn(allReimbursementEntity);
			List<ReimbursementPojo> allReimbursementPojo = new ArrayList<ReimbursementPojo>();
			allReimbursementPojo.add(new ReimbursementPojo(1, 1, 1, 1,true,true,"","", 1, "","",bytePlaceHolder.getBytes()));
			allReimbursementPojo.add(new ReimbursementPojo(2, 1, 1, 1,true,true,"","", 1, "","",bytePlaceHolder.getBytes()));
						
			List<ReimbursementPojo> actualResult=  reimbursementService.viewAllPendingRequests();
			List<ReimbursementPojo> expectedResult = allReimbursementPojo;
			assertEquals(actualResult, expectedResult);
	}*/

/*	@Test
	void testViewAllRequests() {
		String bytePlaceHolder="byte";
		bytePlaceHolder.getBytes();
			List<ReimbursementEntity> allReimbursementEntity = new ArrayList<ReimbursementEntity>();
			allReimbursementEntity.add(new ReimbursementEntity(1, new EmployeeEntity(1,"","","","","",""), 1, true,"", new ResolvedReimbursementEntity(1,true,""), new ImageEntity(1,"","",(long)546,bytePlaceHolder.getBytes())));
			allReimbursementEntity.add(new ReimbursementEntity(2, new EmployeeEntity(2,"","","","","",""), 1, true,"", new ResolvedReimbursementEntity(1,true,""), new ImageEntity(1,"","",(long)546,bytePlaceHolder.getBytes())));
			List<ReimbursementPojo> allReimbursementPojo = new ArrayList<ReimbursementPojo>();
			allReimbursementPojo.add(new ReimbursementPojo(1, 1, 1, 1,true,true,"","", 1, "","",bytePlaceHolder.getBytes()));
			allReimbursementPojo.add(new ReimbursementPojo(2, 2, 1, 1,true,true,"","", 1, "","",bytePlaceHolder.getBytes()));
			
			List<ReimbursementPojo> actualResult=  reimbursementService.viewAllRequests(2);
			List<ReimbursementPojo> expectedResult = allReimbursementPojo;
			
			assertEquals(actualResult, expectedResult);
			
	}*/
	
}
