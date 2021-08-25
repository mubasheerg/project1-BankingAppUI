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

/**
 * Servlet implementation class EditEmployeeAccountController
 */
public class EditEmployeeAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public EditEmployeeAccountController() {
        super();
      
    }

	//to edit employee account
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//out.println("hello employee1");
		
		HttpSession httpSession=request.getSession();
		int employeeId=(int) httpSession.getAttribute("employeeId");
		EmployeeService employeeService=new EmployeeServiceImpl();
		
		//getting old data..
		Employee employee=employeeService.getEmployeeById(employeeId);
		httpSession.setAttribute("userName",employee.getName());
		httpSession.setAttribute("password",employee.getPassword());
		httpSession.setAttribute("mobileNumber",employee.getPhoneNo());
		httpSession.setAttribute("email",employee.getEmailId());
		httpSession.setAttribute("address",employee.getAddress());
		httpSession.setAttribute("salary",employee.getSalary());
		
		//to update data
		//out.println("update section");
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("updateEmployee.jsp");
		requestDispatcher.forward(request, response);
	
	}

	
}
