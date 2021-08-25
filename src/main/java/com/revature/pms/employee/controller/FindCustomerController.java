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
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.impl.CustomerServiceImpl;


public class FindCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FindCustomerController() {
        super();
       
    }

    //search customer by id and view details..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		CustomerService customerService=new CustomerServiceImpl();
		
		
		Customer customer=customerService.getCustomerById(customerId);
		
		//if no customer found in id..
		if(customer==null) {
			
			out.println("<body bgcolor=aqua style=padding:200px><h2 style=text-align:center;color:black>Customer Id:"+ customerId+" Doesn't Exists ,Please enter correct Customer Id");
			out.println("<h2 style=text-align:center><a href=searchCustomer.jsp>TRY AGAIN!</a></h2>");
		
		}
		
		else 
		{
	
			List<Customer> customers=new ArrayList<Customer>();
			customers.add(customer);
			
			httpSession.setAttribute("customerDetails", customers);
			
			
			//in table format
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("displayCustomers.jsp");
			requestDispatcher.forward(request, response);
			
		}
	}

	

}
