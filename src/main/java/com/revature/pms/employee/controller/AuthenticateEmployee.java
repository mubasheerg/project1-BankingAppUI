package com.revature.pms.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.revature.pms.service.EmployeeService;

import com.revature.pms.service.impl.EmployeeServiceImpl;

/**
 * Servlet implementation class AutenticateEmployee
 */
public class AuthenticateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AuthenticateEmployee() {
        super();
    }

	
    //to check customer data in table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int employeeId=Integer.parseInt(request.getParameter("employeeId"));
		String password=request.getParameter("password");
		
		EmployeeService employeeService=new EmployeeServiceImpl();
		HttpSession httpSession=request.getSession();
		
		//validating against id and password
		
			if(employeeService.isEmployeeExists(employeeId))
			{
					if(employeeService.validateEmployee(employeeId,password))
					{
						//if valid id and password
						out.println("<body bgcolor=aqua style=padding:200px><h3 style=text-align:center;color:black>Login Successfull! :)</h3>");
						out.println("<body bgcolor=aqua style=padding:200px><h3 style=text-align:center;color:black>You Are Logged in at :"+ new java.util.Date()+"</h3>");
						httpSession.setAttribute("loginTime",new java.util.Date());
						httpSession.setAttribute("employeeId",employeeId);
						out.println("<h1 style=text-align:center><a href=employeeOperations.jsp><button>Click Me </button></a><h1>");
					}
					else
					{
						//incorrect password or Id
						
						out.println("<body bgcolor=aqua style=padding:200px><h2 style=text-align:center;color:black>Incorrect Employee ID and password , Please Try Again!");
						out.println("<h2 style=text-align:center><a href=employeeLogin.html>TRY AGAIN!</a></h2>");

					}
			}
			else
			{
				//if employee id doesn't found in table

				out.println("<body bgcolor=gray style=padding:200px><h2 style=text-align:center>Employee ID: "+employeeId +" Doesn't Exists");
				out.println("<h2 style=text-align:center><a href=customerLogin.jsp>TRY AGAIN!</a></h2>");
			
				
			}
		}

	}


