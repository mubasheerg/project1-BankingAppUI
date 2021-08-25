package com.revature.pms.service.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pms.model.Employee;
import com.revature.pms.service.EmployeeService;

public class EmployeeServiceImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddEmployee() {
		
		Employee employee=new Employee(0, "chennai", "mena@123", "meena", "123456", "1234567890",1000);
		EmployeeService employeeService=new EmployeeServiceImpl();
		assertEquals(1, employeeService.addEmployee(employee));
	}

	@Test
	public void testDeleteEmployee() { 
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	
	public void testGetEmployeeById() {
		EmployeeService employeeService=new EmployeeServiceImpl();
		Employee employee=employeeService.getEmployeeById(1);
		assertEquals("meena", employee.getName());
	}

	
	@Test
	public void testIsEmployeeExists() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidateEmployee() {
		fail("Not yet implemented");
	}

}
