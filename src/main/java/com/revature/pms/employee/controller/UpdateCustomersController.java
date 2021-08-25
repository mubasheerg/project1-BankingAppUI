package com.revature.pms.employee.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.impl.CustomerServiceImpl;

public class UpdateCustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateCustomersController() {
        super();
            }

	//to update customer..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession httpSession=request.getSession();
		
		CustomerService customerService=new CustomerServiceImpl();
		
		//data from update form
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		String customerName=request.getParameter("userName");
		String password=request.getParameter("password");
		String mobileNumber=request.getParameter("mobileNumber");
		String emailId=request.getParameter("email");
		int balance=Integer.parseInt(request.getParameter("balance"));
		Date date=new Date();
		
		Customer customer1=new Customer(customerId,balance, customerName, emailId, mobileNumber, password, date);
		customerService.updateCustomer(customer1);
		
		 List<Customer> customers = customerService.getCustomers();
	        
		 //displaying updated data
	    httpSession.setAttribute("allCustomers", customers);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("displayAllCustomerDetails.jsp");
		requestDispatcher.forward(request, response);
	}

	
}
