package com.revature.pms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.service.CustomerService;
import com.revature.pms.service.impl.CustomerServiceImpl;

	public class DepositMoneyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public DepositMoneyController() {
        super();
       
    }

    //to deposit money
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		CustomerService customerService=new CustomerServiceImpl();
		HttpSession httpSession=request.getSession();
		
		int amount=Integer.parseInt(request.getParameter("amount"));
		int customerId=(int) httpSession.getAttribute("customerId");
		
		customerService.deposit(customerId, amount);
		
		//to show balance after deposit
		out.println("<body style=text-align:center;padding:200px;background-color:aqua><h2 style=color:black>Deposited Successfully!!</h2>");
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("ViewBalanceController");
		requestDispatcher.include(request, response);
	}

	
}
