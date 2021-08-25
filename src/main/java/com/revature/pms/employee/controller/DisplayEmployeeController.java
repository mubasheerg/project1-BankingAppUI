package com.revature.pms.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.impl.EmployeeServiceImpl;

public class DisplayEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public DisplayEmployeeController() {
        super();
        
    }

	//to view employee account
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		HttpSession httpSession=request.getSession();
		int employeeId=(int) httpSession.getAttribute("employeeId");
		
		EmployeeService employeeService=new EmployeeServiceImpl();
		Employee employee=employeeService.getEmployeeById(employeeId);
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(employee);
		
		httpSession.setAttribute("employeeDetails", employees);
		
		//to print in table format
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("displayEmployeeDetails.jsp");
		requestDispatcher.forward(request, response);
	}

	

}
