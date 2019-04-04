package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmpDao;
import com.model.HrmsEmployeeDetails;
import com.model.HrmsLogin;
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao empDao;
	
	@Transactional
	public List<HrmsEmployeeDetails> getEmployeeDetail(int id) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return empDao.getEmployeeDetail(id);
	}

	@Transactional
	public void updateEmployeePassword(HrmsLogin employeeLogin) {
		// TODO Auto-generated method stub
		empDao.updateEmployeePassword(employeeLogin);
	}

}
