package com.revature.pms.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.impl.CustomerServiceImpl;


public class EditCustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EditCustomersController() {
        super();
        
    }

	//to edit a customer account
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession httpSession=request.getSession();
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		PrintWriter out=response.getWriter();
		
		//out.println("Editing...");
		
		 CustomerService customerService=new CustomerServiceImpl();
		 Customer customer=customerService.getCustomerById(customerId);
		  
		 //to get the previous data from table..
		  httpSession.setAttribute("userName", customer.getCustomerName());
		  httpSession.setAttribute("password", customer.getPassword());
		  httpSession.setAttribute("mobileNumber", customer.getMobileNumber());
		  httpSession.setAttribute("email", customer.getEmailId());
		  httpSession.setAttribute("balance", customer.getBalance());
		  httpSession.setAttribute("customerId", customerId);
		  
		  //form to update fields..
		  RequestDispatcher requestDispatcher=request.getRequestDispatcher("updateCustomersAccount.jsp");
		  requestDispatcher.forward(request, response);
		 
		
	}



}
