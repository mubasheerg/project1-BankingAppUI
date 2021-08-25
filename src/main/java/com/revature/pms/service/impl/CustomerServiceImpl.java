package com.revature.pms.service.impl;

import java.util.List;

import com.revature.pms.dao.CustomerDAO;
import com.revature.pms.dao.Impl.CustomerDAOImpl;
import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.sun.org.apache.bcel.internal.generic.ReturnInstruction;

public class CustomerServiceImpl implements CustomerService{

	CustomerDAO customerDAO=new CustomerDAOImpl();
	@Override
	public int addCustomer(Customer customer) {
		
		return customerDAO.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		
		return customerDAO.deleteCustomer(customerId);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		
		return customerDAO.updateCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		return customerDAO.getCustomerById(customerId);
	}

	@Override
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
		}

	@Override
	public boolean isCustomerExists(int customerId) {
		
		return customerDAO.isCustomerExists(customerId);
	}

	@Override
	public int viewBalance(int customerId) {
		
		return customerDAO.viewBalance(customerId);
	}

	@Override
	public int deposit(int customerId,int amount) {
	
		return customerDAO.deposit(customerId,amount);
	}

	@Override
	public int withdraw(int customerId,int amount) {
		
		return customerDAO.withdraw(customerId,amount);
	
	}

	@Override
	public boolean transferAmount(int senderId, int receiverId, int amount) {
	
		return customerDAO.transferAmount(senderId, receiverId, amount);
	}

	@Override
	public boolean validateCustomer(int customerId, String Password) {
		
		return customerDAO.validateCustomer(customerId, Password);
	}

}
