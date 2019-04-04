package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.HrmsEmployeeLeaves;

@Repository
public class HrmsEmployeeLeavesDaoImpl implements HrmsEmployeeLeavesDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void save(HrmsEmployeeLeaves hrmsEmployeeLeaves) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(hrmsEmployeeLeaves);
	}


	@SuppressWarnings("unchecked")
	public List<HrmsEmployeeLeaves> getLeaveList() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<HrmsEmployeeLeaves> list= session.createQuery("from HrmsEmployeeLeaves").list();
		
		return list;
	}

}
