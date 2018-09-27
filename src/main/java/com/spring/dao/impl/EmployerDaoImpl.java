package com.joseph.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.dao.EmployerDao;
import com.spring.model.Employer;

@Repository
public class EmployerDaoImpl implements EmployerDao {
	@Autowired
	private SessionFactory session;
	
	@Override
	public void add(Employer employer) {
		session.getCurrentSession().save(employer);
	}

	@Override
	public void edit(Employer employer) {
		session.getCurrentSession().update(employer);
	}

	@Override
	public void delete(int employerId) {		
		session.getCurrentSession().delete(getEmployer(employerId));
	}

	@Override
	public Employer getEmployer(int employerId) {
		return (Employer)session.getCurrentSession().get(Employer.class, employerId);
	}

	@Override
	public List getAllEmployer() {
		return session.getCurrentSession().createQuery("from Employer").list();
	}

}
