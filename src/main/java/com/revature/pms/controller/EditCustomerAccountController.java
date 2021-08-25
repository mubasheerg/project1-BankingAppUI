package com.revature.pms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.impl.CustomerServiceImpl;

	public class EditCustomerAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public EditCustomerAccountController() {
        super();
      
    }
    
    //to update customer...
    //this servlet is to get the old data of customer
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();

		int customerId = (int) httpSession.getAttribute("customerId");
		CustomerService customerService=new CustomerServiceImpl();
		Customer customer=customerService.getCustomerById(customerId);
		
		httpSession.setAttribute("userName", customer.getCustomerName());
		httpSession.setAttribute("password", customer.getPassword());
		httpSession.setAttribute("mobileNumber", customer.getMobileNumber());
		httpSession.setAttribute("email", customer.getEmailId());
		httpSession.setAttribute("balance", customer.getBalance());
		
		//a form to enter details that need to update
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("updateCustomer.jsp");
		requestDispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
