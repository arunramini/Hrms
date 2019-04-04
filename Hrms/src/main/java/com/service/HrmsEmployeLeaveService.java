package com.service;

import java.util.List;

import com.model.HrmsEmployeeLeaves;

public interface HrmsEmployeLeaveService {
	public void save(HrmsEmployeeLeaves hrmsEmployeeLeaves);
	public List<HrmsEmployeeLeaves> getLeavesList();
} 
