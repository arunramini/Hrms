package com.service;

import java.util.List;

import com.model.HrmsEmployeeDetails;

public interface AdminService {

	public void addEmployee(HrmsEmployeeDetails hrmsEmployeeDetails);
	public List<HrmsEmployeeDetails> listEmployees();
	public HrmsEmployeeDetails getEmployee(int empId);
	public void removeEmployee(int empId);
}
