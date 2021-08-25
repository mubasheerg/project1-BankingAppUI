package com.revature.pms.dao.Impl;

import java.util.Date;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.revature.pms.dao.CustomerDAO;
import com.revature.pms.dao.CustomerTransactionDAO;
import com.revature.pms.model.Customer;
import com.revature.pms.model.CustomerTransaction;
import com.revature.pms.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO{

	
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session session=sessionFactory.openSession();
	
	@Override
	public int addCustomer(Customer customer) {

		//for dml needs transcation;
		Transaction transaction=session.beginTransaction();
		session.save(customer);
		transaction.commit();
		
		return customer.getCustomerId();
	}
	
	
	
	@Override
	public boolean deleteCustomer(int customerId) {
		Transaction transaction=session.beginTransaction();
		Customer customer=new Customer();
		customer.setCustomerId(customerId);
		session.delete(customer);
		transaction.commit();
		
		return true;
		
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		
		Transaction transaction=session.beginTransaction();
		session.update(customer);
		transaction.commit();
		
		return true;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		
		Customer customer=(Customer) session.get(Customer.class, customerId);
		return customer;
		
	}

	@Override
	public List<Customer> getCustomers() {
		
		Query query=session.createQuery("from com.revature.pms.model.Customer");
		List<Customer>  customers=query.list();
		return customers;
	}

	@Override
	public boolean isCustomerExists(int customerId) {
		
		 
		/*
		  Customer customer1 =new Customer(); customer1.setCustomerId(1);
		  customer1.setPassword("12321123"); Customer customer=(Customer)
		  session.get(Customer.class, customerId);
		  if(customer.equals(customers))
			return true;
			else
			return false;
	*/
		Customer customer=(Customer) session.get(Customer.class, customerId);
		
		if(customer==null)
			return false;
		else
			return true;
	}

	@Override
	public int viewBalance(int customerId) {
		
		
		Query query=session.createQuery("select balance from com.revature.pms.model.Customer where customerId="+customerId);
		int balance=(int) query.list().get(0);
		return balance;
	}

	@Override
	public int deposit(int customerId,int amount) {
		
		Transaction transaction=session.beginTransaction();
		int balance=viewBalance(customerId);
		balance=balance+amount;
		Query query=session.createQuery("update com.revature.pms.model.Customer set balance="+balance+"where customerId="+customerId);
		int status=query.executeUpdate();
		transaction.commit();
		
		balance=viewBalance(customerId);
		
		CustomerTransaction customerTransaction=new CustomerTransaction(0,customerId, balance, amount,customerId,customerId,new Date(),0,0);
		
		CustomerTransactionDAO customerTransactionDAO=new CustomerTransactionDAOImpl();

		customerTransactionDAO.addTransaction(customerTransaction);
		return 1;
		
	}

  
	@Override
	public int withdraw(int customerId, int amount) {
		
		
		Transaction transaction=session.beginTransaction();
		int balance=viewBalance(customerId);
		balance=balance-amount;
		Query query=session.createQuery("update com.revature.pms.model.Customer set balance="+balance+"where customerId="+customerId);
		int status=query.executeUpdate();
		transaction.commit();
		
		balance=viewBalance(customerId);
		
		CustomerTransaction customerTransaction=new CustomerTransaction(0,customerId, balance, 0,customerId,customerId,new Date(),0,amount);
		CustomerTransactionDAO customerTransactionDAO=new CustomerTransactionDAOImpl();

		customerTransactionDAO.addTransaction(customerTransaction);
		return 1;
	}

	@Override
	public boolean transferAmount(int senderId, int receiverId, int amount) {
		
		Transaction transaction=session.beginTransaction();
		int crediterbalance=viewBalance(receiverId);
		crediterbalance=crediterbalance+amount;
		Query query=session.createQuery("update com.revature.pms.model.Customer set balance="+crediterbalance+"where customerId="+receiverId);
		int status=query.executeUpdate();
		
		int debitorbalance=viewBalance(senderId);
		debitorbalance=debitorbalance-amount;
		query=session.createQuery("update com.revature.pms.model.Customer set balance="+debitorbalance+"where customerId="+senderId);
		status=query.executeUpdate();
		transaction.commit();
		
		crediterbalance=viewBalance(receiverId);
		debitorbalance=viewBalance(senderId);
		
		
		CustomerTransaction customerTransaction=new CustomerTransaction(0,senderId, debitorbalance, 0,receiverId,senderId,new Date(),amount,0);
		CustomerTransactionDAO customerTransactionDAO=new CustomerTransactionDAOImpl();

		customerTransactionDAO.addTransaction(customerTransaction);
		
		customerTransaction=new CustomerTransaction(0,receiverId, crediterbalance,amount,receiverId,senderId,new Date(),0,0);
	
		customerTransactionDAO.addTransaction(customerTransaction);
	
		return true;
		
	}

	@Override
	public boolean validateCustomer(int customerId, String password) {
		
		Query query=session.createQuery("from com.revature.pms.model.Customer where customerId="+customerId+ "and password='"+password+"'");
		if(query.list().size()==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

}
