package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DepartmentDao;
import com.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;
	
	@Transactional
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return departmentDao.getDepartments();
	}

}
