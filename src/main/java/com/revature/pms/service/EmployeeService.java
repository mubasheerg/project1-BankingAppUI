package com.revature.pms.service;

import java.util.List;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;

public interface EmployeeService {

	public int addEmployee(Employee employee);
	public boolean deleteEmployee(int employeeId);
	public boolean updateEmployee(Employee employee);
	public Employee getEmployeeById(int employeeId);
	public boolean isEmployeeExists(int employeeId);
	public boolean validateEmployee(int employeeId,String Password);
}
