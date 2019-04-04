package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.HrmsEmployeeLeavesDao;
import com.model.HrmsEmployeeLeaves;
@Service
public class HrmsEmployeeServiceImpl implements HrmsEmployeLeaveService{

	@Autowired
	private HrmsEmployeeLeavesDao hrmsEmployeeLeavesDao;
	
	@Transactional
	public void save(HrmsEmployeeLeaves hrmsEmployeeLeaves) {
		// TODO Auto-generated method stub
		hrmsEmployeeLeavesDao.save(hrmsEmployeeLeaves);
	}

	@Transactional
	public List<HrmsEmployeeLeaves> getLeavesList() {
		// TODO Auto-generated method stub
		return hrmsEmployeeLeavesDao.getLeaveList();
	}

}
