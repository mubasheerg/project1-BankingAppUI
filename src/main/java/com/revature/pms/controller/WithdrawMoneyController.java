package com.revature.pms.controller;

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


public class WithdrawMoneyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public WithdrawMoneyController() {
        super();
       
    }

	//withdraw money
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		CustomerService customerService=new CustomerServiceImpl();
		HttpSession httpSession=request.getSession();
		
		//amount to withdraw..
		int amount=Integer.parseInt(request.getParameter("amount"));
		int customerId=(int) httpSession.getAttribute("customerId");
		
		
		int balance=customerService.viewBalance(customerId);
		
		//balance should be > amount to withdraw
		if(balance<amount)
		{
			out.println("<body bgcolor=gray style=padding:200px><h2 style=text-align:center>Insufficient Balance!!!, Available Balance:"+balance);;
			out.println("<h2 style=text-align:center><a href=withdraw.jsp>TRY AGAIN!</a></h2>");
			
		}
		else {
			customerService.withdraw(customerId, amount);		
			out.println("<body bgcolor=aqua style=text-align:center;padding:200px><h2 style=color:black>Withdrawn Successfully!!</h2>");
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("ViewBalanceController");
			requestDispatcher.include(request, response);
		}
	}

	

}
