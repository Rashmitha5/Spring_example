package com.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.EmployerDao;
import com.spring.model.Employer;
import com.spring.service.EmployerService;
@Service
public class EmployerServiceImpl implements EmployerService {
	@Autowired
	private EmployerDao employerDao;
	
	@Transactional
	public void add(Employer employer) {
		employerDao.add(employer);
	}

	@Transactional
	public void edit(Employer employer) {
		employerDao.edit(employer);
	}

	@Transactional
	public void delete(int employerId) {
		employerDao.delete(employerId);
	}

	@Transactional
	public Employer getEmployer(int employerId) {
		return employerDao.getEmployer(employerId);
	}

	@Transactional
	public List getAllEmployer() {
		return employerDao.getAllEmployer();
	}

}
