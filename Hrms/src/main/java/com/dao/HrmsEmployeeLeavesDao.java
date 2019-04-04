package com.dao;

import java.util.List;

import com.model.HrmsEmployeeLeaves;

public interface HrmsEmployeeLeavesDao {

	public void save(HrmsEmployeeLeaves hrmsEmployeeLeaves);
	
	public List<HrmsEmployeeLeaves> getLeaveList();
}
