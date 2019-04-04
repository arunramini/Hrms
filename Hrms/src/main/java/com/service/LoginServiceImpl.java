package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LoginDao;
import com.model.HrmsLogin;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;

	public LoginDao getLoginDao() {
		return loginDao;
	}

	@Transactional
	public boolean validUser(String username, String password) {

		boolean valid = true;
		HrmsLogin loginAccount = loginDao.getLoginInfo(username,password);
		if (loginAccount == null) {
			valid = false;
		}
		return valid;
	}

	@Transactional
	public String checkRole(String username, String password) {
		HrmsLogin login = loginDao.getLoginInfo(username,password);
		return login.getRole();
	}

	public Map<String, Integer> mapUsers() {
		Map<String, Integer> tblUsers = new HashMap<String, Integer>();
		tblUsers.put("admin", loginDao.getAdminUsers().size());
		tblUsers.put("employee", loginDao.getHrUsers().size());
		tblUsers.put("hr", loginDao.getHrUsers().size());
		return tblUsers;
	}

	@Transactional
	public List<HrmsLogin> getUserList() {
		// TODO Auto-generated method stub
		return loginDao.getLoginUsers();
	}

	@Transactional
	public List<HrmsLogin> getEmployee(String username) {
		// TODO Auto-generated method stub
		return loginDao.getEmployee(username);
	}

}
