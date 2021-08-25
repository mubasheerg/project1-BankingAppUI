package com.revature.pms.employee.controller;

import java.io.IOException;

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

public class ViewAllCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ViewAllCustomerController() {
        super();
        
    }

//to view all customers
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();
		
		CustomerService customerService=new CustomerServiceImpl();
		
		
		List<Customer> customers=customerService.getCustomers();
		
		httpSession.setAttribute("allCustomers", customers);
		
		//in table format
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("displayAllCustomerDetails.jsp");
		requestDispatcher.forward(request, response);
	}

	

}
