package com.revature.pms.dao;

import java.util.List;

import com.revature.pms.model.Employee;

public interface EmployeeDAO {

	public int addEmployee(Employee employee);
	public boolean deleteEmployee(int employeeId);
	public boolean updateEmployee(Employee employee);
	public Employee getEmployeeById(int employeeId);
	public boolean isEmployeeExists(int employeeId);
	public boolean validateEmployee(int employeeId,String Password);
}
