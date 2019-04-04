package com.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.HrmsLogin;

@Repository
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {

		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setLoginInfo(HrmsLogin login) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(login);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	public HrmsLogin getLoginInfo(String username, String password) {
		Session session = this.sessionFactory.getCurrentSession();

		/*
		 * List<HrmsLogin> cr1 = session.createQuery(
		 * "from HrmsLogin e where e.hrmsEmployeeDetails.empId=e.hrmsEmployeeDetails.empId and e.username='"
		 * +username+"'").list();
		 * 
		 * for(HrmsLogin emp:cr1)
		 * System.out.println(emp.getHrmsEmployeeDetails().getEmpId());
		 * 
		 */

		Criteria cr = session.createCriteria(HrmsLogin.class);
		Criterion salary = Restrictions.like("username", username);
		Criterion name = Restrictions.like("password", password);

		LogicalExpression andExp = Restrictions.and(salary, name);
		cr.add(andExp);
		List<HrmsLogin> results = cr.list();
		return results.get(0);

	}

	@SuppressWarnings("unchecked")
	public List<HrmsLogin> getLoginUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<HrmsLogin> loginUsers = session.createQuery("from HrmsLogin").list();
		return loginUsers;
	}

	public void removeLoginInfo(HrmsLogin login) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(login);
		session.flush();
	}

	public void updateUserRole(HrmsLogin login) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(login);

	}

	@SuppressWarnings("unchecked")
	public List<HrmsLogin> getAdminUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(HrmsLogin.class);
		crit.add(Restrictions.like("role", "admin"));
		List<HrmsLogin> users = crit.list();
		return users;
	}

	@SuppressWarnings("unchecked")
	public List<HrmsLogin> getHrUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(HrmsLogin.class);
		crit.add(Restrictions.like("role", "hr"));
		List<HrmsLogin> users = crit.list();
		return users;
	}

	@SuppressWarnings("unchecked")
	public List<HrmsLogin> getEmployeeUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(HrmsLogin.class);
		crit.add(Restrictions.like("role", "employee"));
		List<HrmsLogin> users = crit.list();

		return users;
	}
	
	@SuppressWarnings("unchecked")
	public List<HrmsLogin> getEmployee(String username) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<HrmsLogin> cr1 = session.createQuery(
				"from HrmsLogin e where e.hrmsEmployeeDetails.empId=e.hrmsEmployeeDetails.empId and e.username='"
						+ username + "'")
				.list();

		return cr1;
	}

}
