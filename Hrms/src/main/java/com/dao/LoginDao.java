package com.dao;

import java.util.List;

import com.model.HrmsLogin;

public interface LoginDao {

	public void setLoginInfo(HrmsLogin login);

	public HrmsLogin getLoginInfo(String username,String password);

	public List<HrmsLogin> getLoginUsers();

	public void removeLoginInfo(HrmsLogin login);

	public void updateUserRole(HrmsLogin login);

	public List<HrmsLogin> getAdminUsers();

	public List<HrmsLogin> getHrUsers();

	public List<HrmsLogin> getEmployeeUsers();

}
