package com.dao;

import java.util.List;

import com.model.HrmsEmployeeDetails;
import com.model.HrmsEmployeeLeaves;
import com.model.HrmsLogin;

public interface EmpDao {

	public List<HrmsEmployeeDetails> getEmployeeDetail(int id);
	public void updateEmployeePassword(HrmsLogin employeeLogin);
	public void leaveRequest(HrmsEmployeeLeaves employeeLeave);
}
