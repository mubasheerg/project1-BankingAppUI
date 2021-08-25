package com.revature.pms.controller;

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

public class DeleteCustomerAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DeleteCustomerAccountController() {
        super();
        
    }

    //to delete customer by Id
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int customerId = Integer.parseInt(request.getParameter("customerId"));
        CustomerService customerService = new CustomerServiceImpl();
        customerService.deleteCustomer(customerId);
        
        HttpSession session = request.getSession();
     
        List<Customer> customers = customerService.getCustomers();
        
        session.setAttribute("allCustomers", customers);
        
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("displayAllCustomerDetails.jsp");
 
        dispatcher.forward(request, response);
	}

	
}
