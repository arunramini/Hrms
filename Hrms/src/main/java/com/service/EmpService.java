package com.service;

import java.util.List;

import com.model.HrmsEmployeeDetails;
import com.model.HrmsLogin;

public interface EmpService {

	public List<HrmsEmployeeDetails> getEmployeeDetail(int id);
	public void updateEmployeePassword(HrmsLogin employeeLogin);
}
