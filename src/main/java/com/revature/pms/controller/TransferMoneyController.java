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

public class TransferMoneyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TransferMoneyController() {
		super();

	}

	// to transfer funds..
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		CustomerService customerService = new CustomerServiceImpl();
		HttpSession httpSession = request.getSession();

		// sender id from session..
		int senderId = (int) httpSession.getAttribute("customerId");

		// receiver id from input form
		int receiverId = Integer.parseInt(request.getParameter("receiver"));
		int amount = Integer.parseInt(request.getParameter("amount"));

		// checking receiver id existence
		if (customerService.isCustomerExists(receiverId)) {
			// sender balance should not be less than the amount to transfer

			int balance = customerService.viewBalance(senderId);

			if (balance < amount) {
				if (customerService.transferAmount(senderId, receiverId, amount)) {
					// sender balance should not be less than the amount to transfer
					out.println(
							"<body bgcolor=aqua style=padding:200px><h2 style=text-align:center;color:black>Insufficient Balance!, Available Balance:"
									+ balance);
					;
					out.println("<h2 style=text-align:center><a href=transferAmount.jsp>TRY AGAIN!</a></h2>");
				}

			} else {
				out.println(
						"<body bgcolor=aqua style=text-align:center;padding:200px><h2 style=color:black>Transferred Successfully!</h2>");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("ViewBalanceController");
				requestDispatcher.include(request, response);
			}

		}

		// if receiver id not found
		else {

			out.println(
					"<body bgcolor=aqua style=padding:200px><h2 style=text-align:center;color:black>Incorrect Receiver ID ,Please Try Again!");
			out.println("<h2 style=text-align:center><a href=transferAmount.jsp>TRY AGAIN!</a></h2>");

		}
	}

}
