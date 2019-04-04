package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Leaves;

@Repository
public class LeavesDaoImpl implements LeavesDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Leaves> getLeaves() {
		Session session = sessionFactory.getCurrentSession();
		List<Leaves> list = session.createQuery("from Leaves").list();
		return list;
	}

}
