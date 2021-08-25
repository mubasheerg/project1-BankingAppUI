package com.revature.pms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.pms.dao.CustomerTransactionDAO;
import com.revature.pms.model.Customer;
import com.revature.pms.model.CustomerTransaction;
import com.revature.pms.util.HibernateUtil;

public class CustomerTransactionDAOImpl implements CustomerTransactionDAO{

	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session session=sessionFactory.openSession();
	
	@Override
	public int addTransaction(CustomerTransaction customerTransaction) {
	
		//for dml needs transcation;
		Transaction transaction=session.beginTransaction();
		session.save(customerTransaction);
		transaction.commit();
		
		return 1;
	
	}
	@Override
	public List<CustomerTransaction> getCustomerTransactionById(int customerId) {
		
		Query query=session.createQuery("from com.revature.pms.model.CustomerTransaction where customerId="+customerId);
		List<CustomerTransaction>  customerTransaction=query.list();
		return customerTransaction;
	}
	@Override
	public List<CustomerTransaction> getAllCustomerTransaction() {
		
		Query query=session.createQuery("from com.revature.pms.model.CustomerTransaction");
		List<CustomerTransaction>  customerTransaction=query.list();
		return customerTransaction;
	}

	
}
