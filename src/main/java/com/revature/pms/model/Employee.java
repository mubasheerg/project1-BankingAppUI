package com.revature.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "newbank_employee")

public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int employeeId;
	
	@Column
	private String name;
	
	@Column
	private String password;
	
	@Column
	private String phoneNo;
	
	@Column
	private String emailId;
	
	@Column
	private String address;
	
	@Column
	private int salary;

	public Employee()
	{
		
	}
	public Employee(int employeeId,String address,String emailId,String name,String password,String phoneNo,int salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.password = password;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.address = address;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", password=" + password + ", phoneNo="
				+ phoneNo + ", emailId=" + emailId + ", address=" + address + ", salary=" + salary + "]";
	}
	
	
}
