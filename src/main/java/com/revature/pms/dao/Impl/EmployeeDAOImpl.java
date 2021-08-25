package com.revature.pms.dao.Impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.revature.pms.dao.EmployeeDAO;

import com.revature.pms.model.Employee;
import com.revature.pms.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	
	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session session=sessionFactory.openSession();
	@Override
	public int addEmployee(Employee employee) {
		//for dml needs transcation;
		Transaction transaction=session.beginTransaction();
		session.save(employee);
	    transaction.commit();
					
		return employee.getEmployeeId();
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		Transaction transaction=session.beginTransaction();
		Employee employee=new Employee();
		employee.setEmployeeId(employeeId);
		session.delete(employee);
		transaction.commit();
		return true;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		
		Transaction transaction=session.beginTransaction();
		session.update(employee);
		transaction.commit();
		return true;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
	

		Employee employee=(Employee) session.get(Employee.class, employeeId);
		return employee;
	}

	@Override
	public boolean isEmployeeExists(int employeeId) {
		
		Employee employee=(Employee) session.get(Employee.class, employeeId);
		
		if(employee==null)
			return false;
		else
			return true;
		
	}

	@Override
	public boolean validateEmployee(int employeeId, String password) {
		

		Query query=session.createQuery("from com.revature.pms.model.Employee where employeeId="+employeeId+ "and password='"+password+"'");
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
