package com.revature.pms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.dao.CustomerTransactionDAO;
import com.revature.pms.dao.Impl.CustomerTransactionDAOImpl;
import com.revature.pms.model.CustomerTransaction;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.impl.CustomerServiceImpl;


public class ViewStatementController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ViewStatementController() {
        super();

    }

	//view transaction statements
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession httpSession=request.getSession();
		int customerId=(int) httpSession.getAttribute("customerId");
		
		CustomerTransactionDAO customerTransactionDAO=new CustomerTransactionDAOImpl();
		List<CustomerTransaction> customerTransaction=customerTransactionDAO.getCustomerTransactionById(customerId);
		
		httpSession.setAttribute("customerTransactionDetails", customerTransaction);
		
		//to print in table format
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("viewCustomerStatement.jsp");
		requestDispatcher.forward(request, response);
		
	}



}
