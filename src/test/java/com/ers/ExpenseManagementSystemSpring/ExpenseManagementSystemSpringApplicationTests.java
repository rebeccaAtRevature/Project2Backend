package com.ers.ExpenseManagementSystemSpring;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.TestInstance.Lifecycle;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.Spy;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import com.ers.ExpenseManagementSystemSpring.dao.EmployeeDao;
//import com.ers.ExpenseManagementSystemSpring.entity.EmployeeEntity;
//import com.ers.ExpenseManagementSystemSpring.pojo.EmployeePojo;
//import com.ers.ExpenseManagementSystemSpring.service.EmployeeService;
//import com.ers.ExpenseManagementSystemSpring.service.EmployeeServiceImpl;
//
//import exceptions.SystemException;
//
//@TestInstance(Lifecycle.PER_CLASS)
//@RunWith(MockitoJUnitRunner.class)
//class ExpenseManagementSystemSpringApplicationTests {
//		
//	@InjectMocks
//	EmployeeServiceImpl employeeService;
//	
//	@Mock
//	EmployeeDao employeeDao;	
//	
//	@BeforeAll
//	public void init() {
//		MockitoAnnotations.initMocks(this);
//	}
//	
//	@Test
//	void testFetchEmployee() {
//		when(employeeDao.findById(100)).thenReturn(Optional.of(new EmployeeEntity(100, "Lucy", "Mae",  "(546)309-3823" , "566 Weelia Ct." , "1234","")));
//		EmployeePojo actualResult = employeeService.fetchEmployee(100);
//		EmployeePojo expectedResult = new EmployeePojo(100, "Lucy", "Mae",  "(546)309-3823" , "566 Weelia Ct." , "1234","");
//		
//		assertEquals(actualResult,expectedResult);
//		verify(employeeDao).findById(100);		
//	}
//	
////	@Test
////	void testEmployeeLogin() {
////		EmployeePojo actualResult = employeeService.employeeLogin(100,"1234");
////		EmployeePojo expectedResult = new EmployeePojo(100, "Lucy", "Mae",  "(546)309-3823" , "566 Weelia Ct." , "1234");
////		when(employeeService.fetchEmployee(100)).thenReturn(new EmployeePojo(100, "Lucy", "Mae",  "(546)309-3823" , "566 Weelia Ct." , "1234"));
////		assertEquals(actualResult,expectedResult);
////		verify(employeeDao).fetchEmployee(100);		
////	}
//
//}
