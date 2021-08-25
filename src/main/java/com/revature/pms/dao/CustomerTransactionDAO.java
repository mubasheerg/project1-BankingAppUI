package com.revature.pms.dao;

import java.util.List;

import com.revature.pms.model.Customer;
import com.revature.pms.model.CustomerTransaction;

public interface CustomerTransactionDAO {

	public int addTransaction(CustomerTransaction customerTransaction);
	public List<CustomerTransaction> getCustomerTransactionById(int customerTransaction);
	public List<CustomerTransaction> getAllCustomerTransaction();
}
