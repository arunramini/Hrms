package com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Department;
@Repository
public class DepartmentDaoImpl implements DepartmentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}

}
