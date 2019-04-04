package com.service;

import java.util.List;
import java.util.Map;

import com.model.HrmsLogin;

public interface LoginService {
	
	public boolean validUser(String username, String password);
	public String checkRole(String username, String password);
	public Map<String,Integer> mapUsers();
	public List<HrmsLogin> getUserList();
	public List<HrmsLogin> getEmployee(String username);

}
