package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdminDao;
import com.model.HrmsEmployeeDetails;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao adminDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	@Transactional
	public List<HrmsEmployeeDetails> listEmployees() {
		// TODO Auto-generated method stub
		return adminDao.listEmployees();
	}

	@Transactional
	public void addEmployee(HrmsEmployeeDetails hrmsEmployeeDetails) {
		// TODO Auto-generated method stub
		adminDao.addEmployee(hrmsEmployeeDetails);
	}

	@Transactional
	public HrmsEmployeeDetails getEmployee(int empId) {
		// TODO Auto-generated method stub
		return adminDao.getEmployee(empId);
	}

	@Transactional
	public void removeEmployee(int empId) {
		// TODO Auto-generated method stub
		adminDao.removeEmployee(empId);
	}

}
