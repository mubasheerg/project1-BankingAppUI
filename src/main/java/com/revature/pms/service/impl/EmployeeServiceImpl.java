package com.revature.pms.service.impl;


import com.revature.pms.dao.EmployeeDAO;

import com.revature.pms.dao.Impl.EmployeeDAOImpl;

import com.revature.pms.model.Employee;

import com.revature.pms.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	EmployeeDAO employeeDAO=new EmployeeDAOImpl(); 
	@Override
	public int addEmployee(Employee employee) {
		
		return employeeDAO.addEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		return employeeDAO.deleteEmployee(employeeId);
	}

	@Override
	public boolean updateEmployee(Employee employee) {

		return employeeDAO.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		
		return employeeDAO.getEmployeeById(employeeId);
	}

	@Override
	public boolean isEmployeeExists(int employeeId) {
		
		return employeeDAO.isEmployeeExists(employeeId);
	}

	@Override
	public boolean validateEmployee(int employeeId, String Password) {
		
		return employeeDAO.validateEmployee(employeeId, Password);
	}

	

}
