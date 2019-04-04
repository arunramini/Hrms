package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LeavesDao;
import com.model.Leaves;
@Service
public class LeavesServiceImpl implements LeavesService {

	@Autowired
	private LeavesDao leavesDao;
	
	@Transactional
	public List<Leaves> getLeaves() {
		// TODO Auto-generated method stub
		return leavesDao.getLeaves();
	}

}
