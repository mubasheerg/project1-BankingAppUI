package com.revature.pms.employee.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.impl.CustomerServiceImpl;
import com.revature.pms.service.impl.EmployeeServiceImpl;


public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public EmployeeController() {
        super();
        
    }


    //to add employee
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeName=request.getParameter("userName");
		String password=request.getParameter("password");
		String mobileNumber=request.getParameter("mobileNumber");
		String emailId=request.getParameter("email");
		String address=request.getParameter("address");
		
		int salary=Integer.parseInt(request.getParameter("salary"));
		
		Employee employee=new Employee(0, address, emailId, employeeName,password,mobileNumber,salary);
		EmployeeService employeeService=new EmployeeServiceImpl();
	
		int employeeId=employeeService.addEmployee(employee);
		
		//to login form
		response.setContentType("text/html");
		response.getWriter().println("<body style=text-align:center;padding:200px;backgroud-color:aqua;color:black><h1>"+employeeName + ", congrats you have successfully opened an account in our bank");
		response.getWriter().println("<h3>Please note ur customer id:</a>"+employeeId);
		response.getWriter().println("<h3><a href=employeeLogin.html><button>LOGIN HERE</button></a>");
	}

}
