package com.revature.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.impl.CustomerServiceImpl;

public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateCustomerController() {
        super();
        
    }
    
    //update customers..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();
	
		CustomerService customerService=new CustomerServiceImpl();
		
		//getting data from form
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		String customerName=request.getParameter("userName");
		String password=request.getParameter("password");
		String mobileNumber=request.getParameter("mobileNumber");
		String emailId=request.getParameter("email");
		int balance=Integer.parseInt(request.getParameter("balance"));
		Date date=new Date();
		
		Customer customer1=new Customer(customerId,balance, customerName, emailId, mobileNumber, password, date);
		customerService.updateCustomer(customer1);
		
		//after updating..
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("customerOperations.jsp");
		requestDispatcher.forward(request, response);
		
	}

	
}
