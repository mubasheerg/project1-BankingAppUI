package com.revature.pms.controller;

import java.io.IOException;
import java.util.ArrayList;
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


public class DisplayCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DisplayCustomerController() {
        super();
       
    }

	//to display customer by Id
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		int customerId=(int) httpSession.getAttribute("customerId");
		
		CustomerService customerService=new CustomerServiceImpl();
		
		Customer customer=customerService.getCustomerById(customerId);
		
		List<Customer> customers=new ArrayList<Customer>();
		customers.add(customer);
		
		httpSession.setAttribute("customerDetails", customers);
		
		//to to show the data in table format
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("displayCustomerDetails.jsp");
		requestDispatcher.forward(request, response);
	}



}
