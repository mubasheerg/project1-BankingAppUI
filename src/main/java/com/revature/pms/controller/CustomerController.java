package com.revature.pms.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.impl.CustomerServiceImpl;

public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerController() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		
	}

	public void destroy() {
		
	}

	//to customer data in table
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//getting parameters from signup form
		String customerName=request.getParameter("userName");
		String password=request.getParameter("password");
		int balance=Integer.parseInt(request.getParameter("balance"));
		String mobileNumber=request.getParameter("mobileNumber");
		String emailId=request.getParameter("email");
		
		
		Customer customer=new Customer(0,balance,customerName, emailId, mobileNumber, password,new Date());
		
		CustomerService customerService=new CustomerServiceImpl();
		
		//add customer 
		int customerId=customerService.addCustomer(customer);
		response.setContentType("text/html");
		
		//for login page
		response.getWriter().println("<body style=text-align:center;padding:200px;backgroud-color:gray><h1>"+customerName + ", congrats you have successfully opened an account in our bank with balance of INR "+balance);
		response.getWriter().println("<h3>Please note your customer id:</a>"+customerId);
		response.getWriter().println("<h3>It will be used throughout your lifetime</a>");
		response.getWriter().println("<h2><a href=customerLogin.jsp><button>LOGIN HERE</button></a></h2>");
	
	}

}
