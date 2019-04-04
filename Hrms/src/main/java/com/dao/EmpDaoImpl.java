package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dto.HrmsPassword;
import com.model.HrmsEmployeeDetails;
import com.model.HrmsEmployeeLeaves;
import com.model.HrmsLogin;

@Repository
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<HrmsEmployeeDetails> getEmployeeDetail(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<HrmsEmployeeDetails> list = session.createQuery("from  HrmsEmployeeDetails  e where e.empId=" + id + "")
				.list();
		return list;
	}

	public void updateEmployeePassword(HrmsLogin employeeLogin) {
		// TODO Auto-generated method stub

		String hql = "update HrmsLogin set password = :password  where username =:username";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("password", employeeLogin.getPassword());
		query.setString("username", employeeLogin.getUsername());
		query.executeUpdate();
	}

	public void leaveRequest(HrmsEmployeeLeaves employeeLeave) {
		// TODO Auto-generated method stub
		
	}

	
	
}
