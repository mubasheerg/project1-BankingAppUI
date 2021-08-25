package com.revature.pms.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.service.CustomerService;
import com.revature.pms.service.impl.CustomerServiceImpl;


public class ViewBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewBalanceController() {
        super();
       
    }

	//view balance..
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();
		int customerId=(int) httpSession.getAttribute("customerId");
		CustomerService customerService=new CustomerServiceImpl();
		int balance=customerService.viewBalance(customerId);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<body bgcolor=aqua style=padding:200px><h2 style=text-align:center;color:black>Your Avalaible Balance :"+ balance);
		out.println("<h1 style=text-align:center><a href=customerOperations.jsp><button>Back </button></a><h1>");
	}


}
