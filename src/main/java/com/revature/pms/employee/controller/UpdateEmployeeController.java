package com.revature.pms.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Employee;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.impl.EmployeeServiceImpl;


public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateEmployeeController() {
        super();
        
    }

	//updating employee..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		HttpSession httpSession=request.getSession();
		int employeeId=(int) httpSession.getAttribute("employeeId");
		EmployeeService employeeService=new EmployeeServiceImpl();
		
		
		//data from update form
		String employeeName=request.getParameter("userName");
		String password=request.getParameter("password");
		String mobileNumber=request.getParameter("mobileNumber");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		int salary=Integer.parseInt(request.getParameter("salary"));
		
		Employee employee=new Employee(employeeId, address, email, employeeName, password, mobileNumber, salary);
		
		employeeService.updateEmployee(employee);
		
		
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("employeeOperations.jsp");
		requestDispatcher.forward(request, response);
	
	}
	
	

}
