package com.joseph.service;

import java.util.List;

import com.spring.model.Employer;

public interface EmployerService {
	public void add(Employer employer);
	public void edit(Employer employer);
	public void delete(int employerId);
	public Employer getEmployer(int employerId);
	public List getAllEmployer();
}
