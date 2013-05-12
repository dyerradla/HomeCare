package com.homecare.dao;

import java.util.List;

import org.hibernate.Criteria;

import com.homecare.domain.EmployerInfo;

public class EmployerDAOImpl extends BaseDAO implements IEmployerDAO {

	public List<EmployerInfo> getAllEmployerEmails() {
		Criteria criteria = getSession().createCriteria(EmployerInfo.class);
		List<EmployerInfo> employerEmailList = criteria.list();
		return employerEmailList;
	}
}
