package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.HrmsEmployeeDetails;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<HrmsEmployeeDetails> listEmployees() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<HrmsEmployeeDetails> list = session.createQuery("from HrmsEmployeeDetails").list();

		return list;

	}

	public void addEmployee(HrmsEmployeeDetails hrmsEmployeeDetails) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(hrmsEmployeeDetails);
	}

	public HrmsEmployeeDetails getEmployee(int empId) {
		// TODO Auto-generated method stub

		return (HrmsEmployeeDetails) sessionFactory.getCurrentSession().get(HrmsEmployeeDetails.class, empId);

	}

	public void removeEmployee(int empId) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		HrmsEmployeeDetails customerID = (HrmsEmployeeDetails) session.load(HrmsEmployeeDetails.class, new Integer(empId));
		if (customerID != null) {
			session.delete(customerID);
		}
	}

}
