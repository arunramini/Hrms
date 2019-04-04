package com.dao;

import java.util.List;

import com.model.HrmsEmployeeDetails;

public interface AdminDao {
	public List<HrmsEmployeeDetails> listEmployees();
	public void addEmployee(HrmsEmployeeDetails hrmsEmployeeDetails);
	public HrmsEmployeeDetails getEmployee(int empId);
	public void removeEmployee(int empId);
}
